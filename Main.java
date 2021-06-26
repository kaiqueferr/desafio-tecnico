import java.util.ArrayList;

class Local 
{
  String regiao;
  String codigo;
  Local (String regiao, String codigo)
  {
    this.regiao = regiao;
    this.codigo = codigo;
  }
}

class Tipo
{
  String carater;
  String codigo;
  Tipo(String carater, String codigo)
  {
    this.carater = carater;
    this.codigo = codigo;
  }
}

class Produto
{
  String titulo;
  String codigo;
  String origem;
  String destino;
  String loggi;
  String vendedor;
  String tipo;
  int validade;
  Produto(String titulo,String codigo)
  {
    this.titulo = titulo;
    this.codigo = codigo;
    this.origem = "" + codigo.charAt(0) + codigo.charAt(1)+ codigo.charAt(2);
    this.destino = "" + codigo.charAt(3) + codigo.charAt(4)+ codigo.charAt(5);
    this.loggi = "" + codigo.charAt(6) + codigo.charAt(7)+ codigo.charAt(8);
    this.vendedor = "" + codigo.charAt(9) + codigo.charAt(10)+ codigo.charAt(11);
    this.tipo = "" + codigo.charAt(12) + codigo.charAt(13)+ codigo.charAt(14);
  }
}

class Main 
{
  public static void main(String[] args) 
  {
    Local local[] = new Local[5];
    Tipo tipo[] = new Tipo[5];
    Produto produto[] = new Produto[15];

    produto[0] = new Produto("Pacote 1","888555555123888");
    produto[1] = new Produto("Pacote 2","333333555584333");
    produto[2] = new Produto("Pacote 3","222333555124000");
    produto[3] = new Produto("Pacote 4","000111555874555");
    produto[4] = new Produto("Pacote 5","111888555654777");
    produto[5] = new Produto("Pacote 6","111333555123333");
    produto[6] = new Produto("Pacote 7","555555555123888");
    produto[7] = new Produto("Pacote 8","888333555584333");
    produto[8] = new Produto("Pacote 9","111333555124000");
    produto[9] = new Produto("Pacote 10","333888555584333");
    produto[10] = new Produto("Pacote 11","555888555123000");
    produto[11] = new Produto("Pacote 12","111888555123555");
    produto[12] = new Produto("Pacote 13","888000555845333");
    produto[13] = new Produto("Pacote 14","000111555874000");
    produto[14] = new Produto("Pacote 15","111333555123555");

    local[0] = new Local("Centro-oeste","111");
    local[1] = new Local("Nordeste","333");
    local[2] = new Local("Norte","555");
    local[3] = new Local("Sudeste","888");
    local[4] = new Local("Sul","000");

    tipo[0] = new Tipo("Joias","000");
    tipo[1] = new Tipo("Livros","111");
    tipo[2] = new Tipo("Eletronicos","333");
    tipo[3] = new Tipo("Bebidas","555");
    tipo[4] = new Tipo("Brinquedos","888");

    // Destino de cada pacote ..............................................................................................

    System.out.println("Destino de cada pacote:");
    for(int i = 0; i < 15;i++)
    {
      for(int j = 0; j < 5; j++)
      {
        if(local[j].codigo.equals(produto[i].destino))
        {
          System.out.println("(" + produto[i].titulo + ") Destino: " + local[j].regiao);
        }
      }
    }
    System.out.println("");

    // Codigos de barras válidos e/ou invalidos ..........................................................................................................

    System.out.println("Codigos de barras válidos e/ou invalidos:");
    int test1, test2, test3;
    for(int i = 0; i < 15; i++)
    {
      test1 = 0;
      for(int j = 0; j < 5; j++)
      {
        if(produto[i].tipo.equals(tipo[j].codigo))
        {
          test1 = 1;
        }
      }
      test2 = 1;
      if(produto[i].tipo.equals(tipo[0].codigo) && produto[i].origem.equals(local[0].codigo))
      {
        test2 = 0;
      }
      test3 = 1;
      if(produto[i].vendedor.equals("584"))
      {
        test3 = 0;
      }
      if(test1 == 1 && test2 == 1 && test3 == 1)
      {
        produto[i].validade = 1;
      }
      else
      {
        produto[i].validade = 0;
      }
    }

    for(int i = 0; i < 15; i++)
    {
      if(produto[i].validade == 1)
      {
        System.out.println("(" + produto[i].titulo + ") Codigo valido.");
      }
      else
      {
        System.out.println("(" + produto[i].titulo + ") Codigo invalido.");
      }
    }
    System.out.println("");

    // Pacote que tem como origem a região Sul e tem Brinquedos .....................................................................................

    System.out.println("Pacote que tem como origem a região Sul e tem Brinquedos:");
    int cont = 0;
    for(int i = 0; i < 15; i++)
    {
      if(produto[i].origem.equals("000") && produto[i].tipo.equals("888"))
      {
        System.out.println(produto[i].titulo);
        cont++;
      }
    }
    if(cont == 0)System.out.println("Não ha.");
    System.out.println("");

    // Pacotes agrupados por regiao de destino ..................................................................................................

    System.out.println("Pacotes agrupados por regiao de destino:");

    for(int i = 0; i < 5; i++)
    {
      System.out.println("*Destino: " + local[i].regiao);
      for(int j = 0; j < 15; j++)
      {
        if(produto[j].destino.equals(local[i].codigo))
        {
          if(produto[j].validade == 1)
          {
            System.out.println(produto[j].titulo);
          }
        }
      }
    }
    System.out.println("");


    // Numero de pacotes enviados por cada vendedor ...............................................................................................

    ArrayList<String> vendedorList = new ArrayList();
    int cont2;
    for(int i = 0; i < 15; i++)
    {
      cont2 = 1;
      for(int j = 0; j < vendedorList.size(); j++)
      {
        if(produto[i].vendedor.equals(vendedorList.get(j)))
        {
          cont2 = 0;
        }
        if(produto[i].validade == 0)
        {
          cont2 = 0;
        }
      }
      if(cont2 == 1)
      {
        vendedorList.add(produto[i].vendedor);
      }
    }

    int quant[] = new int[vendedorList.size()];

    for(int i = 0; i < vendedorList.size(); i++)
    {
      quant[i] = 0;
    }

    for(int i = 0; i < vendedorList.size(); i++)
    {
      for(int j = 0; j < 15;j++)
      {
        if(vendedorList.get(i).equals(produto[j].vendedor))
        {
          if(produto[j].validade == 1)
          {
            quant[i]++;
          }
        }
      }
    }

    System.out.println("Numero de pacotes enviados por cada vendedor:");
    int n;
    for(int i = 0 ; i < vendedorList.size(); i++)
    {
      n = i +1;
      System.out.println("Vendedor " + n +"(" + vendedorList.get(i) + "): " + quant[i]);
    }
    System.out.println("");

    // Relatorio/lista de pacotes por destino e por tipo .....................................................................................
    // Obs. Nao compreendi totalmente o que era para fazer no item (f), fiz algo semelhante ao item (d).

    System.out.println("Relatorio/lista de pacotes por destino e por tipo:");
    System.out.println("Por destino:");
    for(int i = 0; i < 5; i++)
    {
      for(int j = 0; j < 15; j++)
      {
        if(produto[j].destino.equals(local[i].codigo))
        {
          if(produto[j].validade == 1)
          {
            System.out.println(produto[j].titulo + " - " + local[i].regiao);
          }
        }
      }
    }
    System.out.println("Por tipo:");
    for(int i = 0; i < 5; i++)
    {
      for(int j = 0; j < 15; j++)
      {
        if(produto[j].tipo.equals(tipo[i].codigo))
        {
          if(produto[j].validade == 1)
          {
            System.out.println(produto[j].titulo + " - " + tipo[i].carater);
          }
        }
      }
    }
  }
}

