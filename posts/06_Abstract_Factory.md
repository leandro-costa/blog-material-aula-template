---
icon: edit
date: 2023-04-27 21:00:00.00 -3
tag:
  - abstract_factory
  - gof
category:
  - aula
order: 6
---

# ABSTRACT FACTORY

[^GAMMA]

## Intenção

Fornecer uma interface para criação de famílias de objetos relacionados ou dependentes sem especificar suas classes concretas.

## Também conhecido como

Kit

## Motivação

Considere um toolkit para construção de interfaces de usuários que suporte múltiplos estilos de interação (look-and-feel) tais como o Motif e o Presentation Manager. Diferentes estilos de interação definem diferentes apresentações e comportamento para os widgets de uma interface de usuário, tais como barras de rolamento, janelas e botões. Para ser portátil entre vários estilos de aparência, uma aplicação não deve codificar rigidamente seus widgets para um determinado padrão. Instanciando classes específicas de estilo de interação para os widgets pela aplicação toda, torna difícil mudar o estilo no futuro.

Podemos resolver esse problema definindo uma classe abstrata WidgetFactory que declara uma interface para criação de cada tipo básico de widget. Existe também uma classe abstrata para cada tipo de widget, e subclasses concretas implementam os widgets para interação. A interface de WidgetFactory tem uma operação que retorna um novo objeto widget para cada classe abstrata de widget. Os clientes chamam estas operações para obter instâncias de widget, mas não têm conhecimento das classes concretas que estão usando. Desta forma, os clientes ficam independentes do padrão de interação usado no momento.

<figure>

```plantuml
@startuml _01
abstract class WidgetFactory{
    +{abstract}CreateScrollBar()
    +{abstract}CreateWindow()
}

class MotifWidgetFactory extends WidgetFactory{

    +CreateScrollBar()
    +CreateWindow()
}

class PMWidgetFactory extends WidgetFactory{

    +CreateScrollBar()
    +CreateWindow()
}

abstract class Window
class PMWindow extends Window
class MotifWindow extends Window



abstract class ScrollBar
class PMScrollBar extends ScrollBar
class MotifScrollBar extends ScrollBar

Client..>WidgetFactory
Client..>Window
Client..>ScrollBar
@enduml

```

<figcaption>UML do toolkit</figcaption>
</figure>


Existe uma subclasse concreta de WidgetFactory para cada estilo de interação. Cada subclasse implementa as operações para criar o widget apropriado para aquele estilo de interação. Por exemplo, a operação CreateScrollBar aplicada à MotifWidgetFactory instancia e retorna uma barra de rolamento de acordo com o Motif, enquanto que a correspondente operação aplicada à PMWidgetFactory retorna uma barra de rolamento para o Presentation Manager. Os clientes criam widgets exclusivamente através da interface de WidgetFactory e não tem conhecimento das classes que implementam os widgets para um padrão em particular. Em outras palavras, os clientes têm somente que se comprometer com uma interface definida por uma classe abstrata, não uma determinada classe concreta. Uma WidgetFactory também implementa e garante as dependências entre as classes concretas de widgets. Uma barra de rolamento Motif deveria ser usada com um botão Motif e um editor de textos Motif, e essa restrição é garantida automaticamente como conseqüência de usar uma MotifWidgetFactory.

## Aplicabilidade

Use o padrão Abstract Factory quando:

- um sistema deve ser independente de como seus produtos são criados, compostos ou representados;
- um sistema deve ser configurado como um produto de uma família de múltiplos produtos;
- uma família de objetos-produto for projetada para ser usada em conjunto, e você necessita garantir esta restrição;
- você quer fornecer uma biblioteca de classes de produtos e quer revelar somente suas interfaces, não suas implementações.


## Estrutura

<figure>

```plantuml
@startuml _02
abstract class AbstractFactory{

    +{abstract}CreateProductA()
    +{abstract}CreateProductB()
}

class ConcreteFactory1 extends AbstractFactory{

    +CreateProductA()
    +CreateProductB()
}

class ConcreteFactory2 extends AbstractFactory{

    +CreateProductA()
    +CreateProductB()
}

Client ..> AbstractFactory
Client ..> AbstractProductA
Client ..> AbstractProductB

abstract class AbstractProductA
class ProductA1 extends AbstractProductA
class ProductA2 extends AbstractProductA

abstract class AbstractProductB
class ProductB1 extends AbstractProductB
class ProductB2 extends AbstractProductB


@enduml

```


<figcaption>UML da Estrutura</figcaption>
</figure>

## Participantes
- **AbstractFactory** (WidgetFactory)
    - declara uma interface para operações que criam objetos-produto abstratos.

- **Concrete Factory** (MotifWidgetFactory, PMWidgetFactory)
    - implementa as operações que criam objetos-produto concretos.

- **AbstractProduct** (Window, ScrollBar)
    - declara uma interface para um tipo de objeto-produto

- **ConcreteProduct** (MotifWindow, MotifScrollBar)
    - define um objeto-produto a ser criado pela correspondente fábrica concreta.
    - implementa a interface de Abstract Product.

- **Client** 
    - Usa as interfaces declaradas pelas classes AbstractFactory e AbstractProduct.


## Colaborações

- Normalmente uma única instância de uma classe ConcreteFactory é criada em tempo de execução. Essa fábrica concreta cria objetos-produto que têm uma implementação particular. Para criar diferentes objetos-produto, os clientes deveriam usar uma fábrica concreta diferente.
- AbstractFactory adia a criação dos objetos-produto para as suas subclasses ConcreteFactory.


## Consequências

O padrão Abstract Factory tem os seguintes benefícios e desvantagens:

1. Ele isola as classes concretas. O padrão Abstract Factory ajuda a controlar as classes de objetos criadas por uma aplicação. Uma vez que a fábrica encapsula a responsabilidade e o processo de criar objetos-produto, isola os clientes das classes de implementação. Os clientes manipulam as instâncias através das suas interfaces abstratas. Nomes de classes-produto ficam isolados na implementação da fábrica concreta; eles não aparecem no código do cliente.
2. Ele torna fácil a troca de famílias de produtos. A classe de uma fábrica concreta aparece apenas uma vez numa aplicação – isto é, quando é instanciada. Isso torna fácil mudar a fábrica concreta que uma aplicação usa. Ela pode usar diferentes configurações de produtos simplesmente trocando a fábrica concreta. Uma vez que a fábrica abstrata cria uma família completa de produtos, toda família de produtos muda de uma só vez. No nosso exemplo de interface de usuário, podemos mudar de widgets do Motif para widgets do Presentation Manager simplesmente trocando os correspondentes objetosfábrica e recriando a interface.
3. Ela promove a harmonia entre produtos. Quando objetos-produto numa família são projetados para trabalharem juntos, é importante que uma aplicação use objetos de somente uma família de cada vez. AbstractFactory torna fácil assegurar isso.
4. É difícil de suportar novos tipos de produtos. Estender fábricas abstratas para produzir novos tipos de Produtos não é fácil. Isso se deve ao fato de que a interface de AbstractFactory fixa o conjunto de produtos que podem ser criados. Suportar novos tipos de produto exige estender a interface da fábrica, o que envolve mudar a classe AbstractFactory e todas as suas subclasses. Discutimos uma solução para este problema na seção de Implementação.


## Implementação

- A classe AbstractFactory é aquela que determina o tipo real do objeto concreto e o cria, mas retorna uma referência abstrata ao objeto concreto recém-criado.
- Isso determina o comportamento do cliente que pede à fábrica para criar um objeto de um determinado tipo abstrato e retornar o ponteiro abstrato para ele, impedindo que o cliente saiba algo sobre a criação real do objeto.
- O fato da fábrica retornar um ponteiro abstrato para o objeto criado significa que o cliente não tem conhecimento do tipo do objeto. Isso implica que não há necessidade de incluir nenhuma declaração de classe relacionada ao tipo concreto, o cliente lida o tempo todo com o tipo abstrato.
- Os objetos do tipo concreto, criados pela fábrica, são acessados pelo cliente apenas através da interface abstrata. A segunda implicação dessa maneira de criar objetos é que, ao adicionar novos tipos concretos, basta modificar o código do cliente e fazer com que ele use uma fábrica diferente, o que é muito mais fácil do que instanciar um novo tipo, o que requer alteração o código sempre que um novo objeto é criado.


A implementação clássica para o padrão Abstract Factory é a seguinte:


````java

abstract class AbstractProductA 
{
	public abstract void operationA1();
	public abstract void operationA2();
}

class ProductA1 extends AbstractProductA 
{
	ProductA1(String arg)
	{
		System.out.println("Hello "+arg);
	} 
	// Implement the code here
	public void operationA1() { };
	public void operationA2() { };
}

class ProductA2 extends AbstractProductA 
{
	ProductA2(String arg)
	{
		System.out.println("Hello "+arg);
	} 
	// Implement the code here
	public void operationA1() { };
	public void operationA2() { };
}

abstract class AbstractProductB 
{
	public abstract void operationB1();
	public abstract void operationB2();
}

class ProductB1 extends AbstractProductB 
{
	ProductB1(String arg)
	{
		System.out.println("Hello "+arg);
	} 
	// Implement the code here
}

class ProductB2 extends AbstractProductB 
{
	ProductB2(String arg)
	{
		System.out.println("Hello "+arg);
	} 
	// Implement the code here
}

abstract class AbstractFactory 
{
	abstract AbstractProductA createProductA();
	abstract AbstractProductB createProductB();
}

class ConcreteFactory1 extends AbstractFactory 
{
	AbstractProductA createProductA()
	{
		return new ProductA1("ProductA1");
	}
	AbstractProductB createProductB()
	{
		return new ProductB1("ProductB1");
	}
}

class ConcreteFactory2 extends AbstractFactory 
{
	AbstractProductA createProductA()
	{
		return new ProductA2("ProductA2");
	}
	AbstractProductB createProductB()
	{
		return new ProductB2("ProductB2");
	}
}


//Factory creator - an indirect way of instantiating the factories
class FactoryMaker 
{
	private static AbstractFactory pf=null;
	static AbstractFactory getFactory(String choice)
	{
		if(choice.equals("a"))
		{
			pf=new ConcreteFactory1();
		}
		else if(choice.equals("b"))
		{
			pf=new ConcreteFactory2();
		} 
		return pf;
	}
}


// Client
public class Client
{
	public static void main(String args[])
	{
		AbstractFactory pf=FactoryMaker.getFactory("a");
		AbstractProductA product=pf.createProductA();
		//more function calls on product
	}
}

````


## Exemplo de código

Uma rede de fast food deseja abrir várias franquias em dois pais diferentes para estender seus negócios.Os países escolhidos foram Brasil e U.S.A(Estados Unidos da America). Por ser pequena ainda a empresa só entrega aos clientes dois tipos de hambúrguer, "Normal", um hambúrguer um pouco mais barato e mais simples em sua composição e o hambúrguer "Gourmet" que acaba sendo mais caro, porém, seus ingredientes são de melhor qualidade. O que difere cada tipo sendo 
Normal e Gourmet é o: o tipo do pão, o tipo da Carne, o tipo do Queijo e o tipo do Molho. Que variam de acordo com qual dos dois locais está essa franquia.

O código abaixo inlustra um sistema feito para quê o cliente de um desses dois países solicite um hambúrguer de cada um dos dois tipos seguindo a customização de cada país.

1. Primeiro é criado uma classe abstrata chamada **FabricaAbstrataHamburger** que contem duas assinturas de metódos:
- **CriarHamburgerUSA()** que retorna um objeto do tipo **HamburgerUSA**
- **CriarHamburgerBrasil()** que retorna um objeto do tipo **HamburgerBrasil**;

````java

public abstract class FabricaAbstrataHamburger {
    public abstract HamburgerUSA    CriarHamburgerUSA();
    public abstract HamburgerBrasil CriarHamburgerBrasil();
    
}

````
2. Criamos uma classe abstrata: **Hamburger** que apenas vai servir de base para os dois tipos de hamburges: Brasil e USA;

````java
public abstract class Hamburger {
    public String tipoDoPao;
    public String tipoDaCarne;
    public String tipoDoQueijo;
    public String tipoDoMolho;
    
}
````

3. Criamos os dois tipos de hamburges **HamburgerUSA** e **HamburgerBrasil**, eles vão extender da classe **Hamburger**;

````java
public class HamburgerBrasil extends Hamburger{
    public String tipoDoPao;
    public String tipoDaCarne;
    public String tipoDoQueijo;
    public String tipoDoMolho;

    public HamburgerBrasil(String tipoDoPao, String tipoDaCarne, String tipoDoQueijo, String tipoDoMolho) {
        this.tipoDoPao    = tipoDoPao;
        this.tipoDaCarne  = tipoDaCarne;
        this.tipoDoQueijo = tipoDoQueijo;
        this.tipoDoMolho  = tipoDoMolho;
    }
    
    public HamburgerBrasil clone(){
        
        return new HamburgerBrasil(this.tipoDoPao, this.tipoDaCarne, this.tipoDoQueijo, this.tipoDoMolho);
        
    }

    @Override
    public String toString() {
        return "HamburgerBrasil{" + "tipoDoPao=" + tipoDoPao + ", tipoDaCarne=" + tipoDaCarne + ", tipoDoQueijo=" + tipoDoQueijo + ", tipoDoMolho=" + tipoDoMolho + '}';
    }
  
}

````

````java
public class HamburgerUSA extends Hamburger{
    public String tipoDoPao;
    public String tipoDaCarne;
    public String tipoDoQueijo;
    public String tipoDoMolho;

    public HamburgerUSA(String tipoDoPao, String tipoDaCarne, String tipoDoQueijo, String tipoDoMolho) {
        this.tipoDoPao    = tipoDoPao;
        this.tipoDaCarne  = tipoDaCarne;
        this.tipoDoQueijo = tipoDoQueijo;
        this.tipoDoMolho  = tipoDoMolho;
    }
    
    public HamburgerUSA clone(){
        
        return new HamburgerUSA(this.tipoDoPao, this.tipoDaCarne, this.tipoDoQueijo, this.tipoDoMolho);
        
    }

    @Override
    public String toString() {
        return "HamburgerUSA{" + "tipoDoPao=" + tipoDoPao + ", tipoDaCarne=" + tipoDaCarne + ", tipoDoQueijo=" + tipoDoQueijo + ", tipoDoMolho=" + tipoDoMolho + '}';
    }
     
}

````

Nas duas classes há um metódo clone, quê usando a proposta do padão **Prototype**, retorna um clone do tipo do Hamburger ao inves de uma nova instancia; 


4. Agora, criamos duas classes concretas:
- **FabricaConcretaHamburgerGourmet** que representa um hambúrger Gourmet que pode ser tanto do tipo Brasil quanto USA;
- **FabricaConcretaHamburgerNormal**  que representa um hambúrger Normal que pode ser também tanto do tipo Brasil quanto USA;
Os dois vão extender de classe abstrata **FabricaAbstrataHamburger** e herdar seus metódos;

````java
public class FabricaConcretaHamburgerGourmet extends FabricaAbstrataHamburger{

    @Override
    public HamburgerUSA CriarHamburgerUSA() {
       
        HamburgerUSA hamburgerGourmetUSA = new HamburgerUSA("GourmetUSA", "GourmetUSA", "GourmetUSA", "GourmetUSA");
        return hamburgerGourmetUSA.clone();
       
    }

    @Override
    public HamburgerBrasil CriarHamburgerBrasil() {
        
        HamburgerBrasil hamburgerGourmetBrasil = new HamburgerBrasil("GourmetBra", "GourmetBra", "GourmetBra", "GourmetBra");
        return hamburgerGourmetBrasil.clone();
       
        
    }
    
}
````

````java
public class FabricaConcretaHamburgerNormal extends FabricaAbstrataHamburger{

    @Override
    public HamburgerUSA CriarHamburgerUSA() {
        
        HamburgerUSA hamburgerNormalUSA = new HamburgerUSA("NormalUSA", "NormalUSA", "NormalUSA", "NormalUSA");
        return hamburgerNormalUSA.clone();
        
    }

    @Override
    public HamburgerBrasil CriarHamburgerBrasil() {
       
        HamburgerBrasil hamburgerNormalBrasil = new HamburgerBrasil("NormalBra", "NormalBra", "NormalBra", "NormalBra");
        return hamburgerNormalBrasil.clone();
       
    }

}
````
Cada metódo vai retornar ou um clone de um objeto do tipo **HamburgerUSA** ou do tipo **HamburgerBrasil**, com uma serie de argumentos predefinidos
para inlustar cada modelo de hamburger;


5. Por fim vamos só visualizar os resultados:


````java
public class Client {
    public static void main(String[] args) {
       FabricaAbstrataHamburger fchg = new FabricaConcretaHamburgerGourmet();
       FabricaAbstrataHamburger fchn = new FabricaConcretaHamburgerNormal();
        
       HamburgerBrasil burgerBrGourmet = (HamburgerBrasil) fchg.CriarHamburgerBrasil();
       System.out.println(burgerBrGourmet);
       
       HamburgerUSA burgerUSANormal = (HamburgerUSA) fchn.CriarHamburgerUSA();
       System.out.println(burgerUSANormal);
       
        
    }
}

````

````console

HamburgerBrasil{tipoDoPao=GourmetBra, tipoDaCarne=GourmetBra, tipoDoQueijo=GourmetBra, tipoDoMolho=GourmetBra}
HamburgerUSA{tipoDoPao=NormalUSA, tipoDaCarne=NormalUSA, tipoDoQueijo=NormalUSA, tipoDoMolho=NormalUSA}

````

5. Vejamos esse código em um diagrama UML


<figure>

```plantuml
@startuml
abstract class FabricaAbstrataHamburger{
    +{abstract}CriarHamburgerUSA()
    +{abstract}CriarHamburgerBrasil()
 }

 class FabricaConcretaHamburgerGourmet extends FabricaAbstrataHamburger{
    +CriarHamburgerUSA()
    +CriarHamburgerBrasil()
 }

 class FabricaConcretaHamburgerNormal extends FabricaAbstrataHamburger{
    +CriarHamburgerUSA()
    +CriarHamburgerBrasil()
 }

 abstract class HamburgerNormal

 class HamburgerNormalBrasileiro  extends HamburgerNormal{}
 class HamburgerNormalUSA  extends HamburgerNormal{}

 abstract class HamburgerGourmet

 class HamburgerGourmetUSA extends HamburgerGourmet{}
 class HamburgerGourmetBrasileiro extends HamburgerGourmet{}

 Cliente..>FabricaAbstrataHamburger
 Cliente..>HamburgerNormal
 Cliente..>HamburgerGourmet

 FabricaConcretaHamburgerNormal..>HamburgerNormalBrasileiro
 FabricaConcretaHamburgerNormal..>HamburgerNormalUSA

 FabricaConcretaHamburgerGourmet..>HamburgerGourmetBrasileiro
 FabricaConcretaHamburgerGourmet..>HamburgerGourmetUSA
@enduml

```
<figcaption>UML do Exemplo</figcaption>
</figure>

## Usos conhecidos

- InterViews usa fábricas abstratas para
encapsular diferentes tipos de aparências para
sua interface gráfica.

- ET++ usa fábricas abstratas para permitir a
fácil portabilidade para diferentes ambientes de
janelas (XWindows e SunView, por exemplo).

- Sistema de captura e reprodução de vídeo feito
na UIUC usa fábricas abstratas para permitir
portabilidade entre diferentes placas de captura
de vídeo.

- Em linguagens dinâmicas como Smalltalk

## Padrão relacionados
As classes AbstractFactory são freqüentemente implementadas com métodos-fábrica **Factory Method**, mas elas também podem ser implementadas usando **Prototype**. Uma fábrica concreta é freqüentemente um **singleton**.

## Referências

- **ERICK GAMMA**, Padrões de Projetos: Soluções Reutilizáveis de Software Orientados a Objetos,  Bookman; 1ª edição (1 janeiro 2000)
- **ABSTRACT FACTORY PATTERN - STARTERTUTORIALS**, https://www.startertutorials.com/patterns/abstract-factory-pattern.html
- **REFACTORING GURU:** https://refactoring.guru/pt-br/design-patterns/abstract-factory
- **UNIVASF - "Padrões de Projeto de Software Orientado a Objetos" - Ricardo Argenton Ramos -** - http://www.univasf.edu.br/~ricardo.aramos/disciplinas/ES_II_2010_1/aulas/Aula_04.pdf

