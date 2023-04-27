---
icon: edit
date: 2023-04-26 13:15:00.00 -3
tag:
  - builder
  - gof
category:
  - aula
order: 5
---

# Builder (GOF)


[^GAMMA]
[^Shvets]
 
 
## Intenção

Permite a separação da criação de objetos complexos de suas representações, produzindo diferentes tipos e representações do objeto com o mesmo processo de construção.

## Também conhecido como

Constructor

## Motivação

Um leitor de um documento em RTF (Rich Text Format) deveria ser capaz de converter RTF em muitos formatos de texto. O leitor poderia converter documentos RTF em texto ASCII comum ou widget de texto, que possa ser editado interativamente. O problema, contudo, é que o número de conversões possíveis é aberto. Por isso, deve ser fácil acrescentar uma nova conversão sem modificar o leitor. 

Uma solução é configurar a classe RTFReader com um objeto TextConverter que converte RTF para uma outra representação de textos. À medida que o RTFReader analisa o documento RTF, ele usa o objeto TextConverter para efetuar a conversão. Sempre que o RTFReader reconhece um símbolo RTF (texto simples, ou uma palavra de controle do RTF), ele emite uma solicitação para o TextConverter para converter esse símbolo. Os objetos TextConverter são responsáveis tanto por efetuar a conversão dos dados como pela representação do símbolo num formato particular.

As subclasses de TextConverter se especializam em diferentes conversões e formatos. Por exemplo, um ASCIIConverter ignora solicitações para converter qualquer coisa, exceto texto simples. Por outro lado, um TeXConverter implementará operações para todas as solicitações visando produzir uma representação TEX que capture toda a informação estilística do texto. Um TextWidgetConverter produzirá um objeto para uma interface de usuário complexa que permite ao usuário ver e editar o texto.


<figure>

```plantuml
@startuml

class RTFReader{
   ParseRTF()
}

class TextConverter{
   ConvertCharacter(char)
   ConvertFontChange(Font)
   ConvertParagraph()
}

class ASCIIConverter{
   ConvertCharacter(char)
   GetASCIIText()
}

class TeXConverter{
   ConvertCharacter(char)
   ConvertFontChange(Font)
   ConvertParagraph()
   GetTeXText()
}

class TextWidgetConverter{
   ConvertCharacter(char)
   ConvertFontChange(Font)
   ConvertParagraph()
   GetTestWidget()
}

note bottom of RTFReader
  while (t = get the next token) {
    switch t.Type {
      CHAR: builder–>CovertCharacter(t.Char) 
      FONT: builder–>ConvertFontChange(t.Font) 
      PARA: builder–>ConvertParagraph()
    }
  }
end note


RTFReader o-> TextConverter:builder

TextConverter<|-- ASCIIConverter 
TextConverter<|-- TeXConverter
TextConverter<|-- TextWidgetConverter

ASCIIConverter ..> ASCIIText

TeXConverter..> TeXText

TextWidgetConverter..> TextWidget


hide empty attributes
hide empty methods
@enduml
```

<figcaption>Motivação Builder.</figcaption>
</figure>

Cada tipo de classe conversora implementa o mecanismo para criação e montagem de um objeto complexo, colocando-o atrás de uma interface abstrata. O
conversor é separado do leitor, que é responsável pela análise de um documento RTF.

O padrão Builder captura todos estes relacionamentos. Cada classe conversora é chamada um **builder** no padrão, e o leitor é chamado de **director**. Aplicado a este exemplo, o Builder separa o algoritmo para interpretar um formato de texto (isto é, o analisador de documentos RTF) de como um formato convertido é criado e representado. Isso nos permite reutilizar o algoritmo de análise (parsing) do RTFReader para criar diferentes representações de texto a partir de documentos RTF – simplesmente configure o RTFReader com diferentes subclasses de TextConverter.

## Aplicabilidade

Use o padrão Builder quando:

- o algoritmo para criação de um objeto complexo deve ser independente das partes que compõem o objeto e de como elas são montadas;
- existem classes com construtores com muitos parâmetros opcionais ou classes que tenham muitas versões de construtores sobrecarregadas;
- você precisa que seu código permita a criação de diferentes representações de um Objeto. Ex: Casa --> Casa de Madeira e Casa de Pedra;
- você quer construir uma árvore de Objetos utilizando o **Composite**;


## Um pouco sobre o Composite

O Composite é um padrão de projeto estrutural que permite que a composição de objetos em estruturas de árvores que representam hierarquias partes-todo. Após a composição, estas estruturas podem ser utilizadas da mesma maneira que objetos individuais.

Usar o padrão Composite faz sentido apenas quando o modelo central de sua aplicação pode ser representada como uma árvore.
Por exemplo, imagine que você tem dois tipos de objetos:
**Produtos** e **Caixas**. Uma **Caixa** pode conter diversos **Produtos** bem como um número de **Caixas** menores. Essas **Caixas** menores também podem ter alguns **Produtos** ou até mesmo **Caixas** menores que elas, e assim em diante..

Nesse tipo de cenário, seria possivel utilizar o Builder para criar as árvores Composite complexas (representadas pelas **Caixas**) porque o Builder permite que você programe as etapas de construção para trabalhar recursivamente. Facilitando assim a criação de objetos em estruturas de árvore para a utilização do padrão Composite.

Builder e Composite são popularmente utilizados em conjunto, devido a essa combinação de construção e organização de objetos complexos.



## Estrutura
O Padrão Builder possui uma estrutura com 4 participantes, como ilustrado abaixo :

<figure>

```plantuml
@startuml
interface Builder{
BuildPart()
}

class Director{
Builder builder
Construct()
}

note bottom of Director
foreach item in structure {
   builder.BuildPart()
}
end note


Director o-> Builder:builder

class ConcreteBuilder{
    BuildPart()
    GetResult()
}


Builder <|-- ConcreteBuilder
ConcreteBuilder -right..> Product


hide empty attributes
hide empty methods
@enduml
```

<figcaption>Estrutura Builder.</figcaption>

</figure>

## Participantes

- **Builder** (TextConverter)
    - define uma interface com as configurações em comum para todos os objetos que são baseados nesse Builder. Director usa esta interface para chamar o método definido por um ConcreteBuilder.
- **ConcreteBuilder** (ASCIIConverter, TeXConverter, TextWidgetConverter)
    - implementa métodos para a construção e montagem em partes do produto, usando a interface de Builder.
    - Não expõe o produto durante a montagem, mantém a representação até o objeto ser recuperado.
    - ConcreteBuilders devem fornecer seus próprios métodos para recuperar os resultados de construções, já que os produtos gerados podem ser completamente diferentes.
- **Director** (RTFReader)
    - Mantém uma instancia de um Builder passado pelo cliente.
    - atua como controlador do Builder passado e implementa métodos visando a execução sequencial correta e a organização das etapas de configuração para cada tipo de situação.

- **Product** (ASCIIText, TeXText, TextWidget)
    - representa o objeto complexo em construção. ConcreteBuilder constrói a representação interna do produto e define o as etapas de montagem;
    - inclui classes que definem as diversas partes que constituem o objeto complexo, inclusive as interfaces para a montagem das partes no resultado final.


## Colaborações
- O cliente cria o objeto Director e o configura com o objeto Builder desejado.
- Director utiliza o Builder para notificar que o processo de montagem de uma parte do produto deve ser executado.
- Builder trata solicitações do Director e acrescenta partes ao produto.
- O cliente recupera o produto após a montagem do Builder.

## Consequências

O padrão Builder tem os seguintes benefícios e desvantagens:

### Benefícios 
1. Permite a construção de objetos passo a passo, pular certas etapas de construção ou rodar etapas recursivamente.
2. Mantém a lógica complexa de construção isolada da lógica de negócio do produto, melhorando a modularidade pelo encapsulamento da forma que um objeto é construido e representado.
3. Permite a variação da representação interna do produto, já que o diretor somente tem acesso a uma interface abstrata Builder, ocultando a estrutura interna do produto e como ele é construido, logo, para adicionar ou modificar uma representação só é preciso definir um novo tipo de construtor.


### Desvantagens 

1. A complexidade do código aumenta, já que o padrão necessita da criação de múltiplas classes novas.


## Implementação
Eis um exemplo para representar a implementação do padrão **Builder** em java:

```java
public interface Builder {
    public void buildPart(Part productPart); // define a montagem de uma parte
     //Part é uma classe abstrata
}
```

```java
public class ConcreteBuilder implements Builder {
    private Part productPart;

    @Override
    public void buildPart(Part productPart){
        this.productPart = productPart;
    };

     public Product getResult() {
        return new Product(productPart);
    }
}
```

```java
public class Director {
    private Builder builder;

     public void constructProduct(Builder builder) {
        Part exempleProductPart = new SpecificProductPart();
        // SpecificProductPart representa uma classe que implementa a classe abstrata Part

        builder.buildPart(exempleProductPart);
    }
}
```

Para melhor contextualização, a classe do produto final seria escrita assim:

```java
public class Product {
    private final Part productPart;
   
    public Product(Part productPart){
        this.productPart = productPart;
    }

    public Part getPart(){
        return productPart;
    }    
}
```

Com essas implementações, este seria o código cliente (código da aplicação):

```java
public class Client {

    public static void main(String[] args) {
        Director director = new Director();

        //Director usa o objeto ConcreteBuilder dado pelo cliente.
        //Isto porque o código cliente sabe qual o builder correto a ser utilizado para gerar um produto especifico.
        ConcreteBuilder builder = new ConcreteBuilder();
        director.constructProduct(builder);

        //O produto final é retornado pela instância de builder, 
        //já que director não enxerga e não depende de um concreteBuilder especifico e seu produto final.
        Product product = builder.getResult();

        //Faz algo com o produto ou constrói outros produtos
    }
}
```


## Exemplo de código

Consideremos um contexto onde é preciso construir objetos complexos que representam as peças de um jogo de tabuleiro, cada peça tem uma cabeça, um corpo, pés e um equipamento (como uma lança) e o jeito que é permitido se mover. Isto é importante para que cada peça tenha um devido papel baseado nas suas partes. O código a seguir, utiliza o padrão Builder para facilitar a construção de peças padrões do jogo.

Para facilitar o entendimento, implementaremos primeiro as representações das partes das peças:

A maioria das partes a seguir são enums, atribuindo um valor representativo e evitando que o código do exemplo seja muito grande.

```java
public enum PieceHead {
    HUMAN, LIZARD, ROBOT, SKELETON
}
```

```java
public enum PieceBody {
    FLESH, SCALES, METALIC, BONES
}
```


```java
public enum PieceFeet {
    BIPEDS, QUADRUPED, TANK_TREAD, PROPULSOR
}
```


PieceEquipament é criado como uma classe abstrata para definir os papéis obrigatórios que um equipamento deve ter, esta abordagem permite a criação de vários equipamentos diferentes.

```java
public abstract class PieceEquipament {
    private int defense;
    private int attack;
    private EquipamentType type; 
    private boolean broken;

    public int getDefense();

    public int getAttack();

    public EquipamentType getType();

    public boolean breakingCondition(EquipamentAction action); 
}
```

Agora que temos todas as representações que precisamos, podemos começar a implementar o padrão Builder.

Código da interface que representa uma peça, apelidado de **BoardPieceBuilder** :

```java
public interface BoardPieceBuilder {
    public void buildHead(PieceHead head); // define a montagem da cabeça
    public void buildBody(PieceBody body); // define a montagem do corpo
    public void buildFeet(PieceFeet feet); // define a montagem dos pés
    public void buildEquipament(PieceEquipament equipament); // define a montagem do equipamento
    public void setName(String name); // define o nome personalizado da peça
}
```

A interface define os possiveis parâmetros para a construção de uma peça de tabuleiro, fazendo o papel do participante **Builder**.

Beseado nisso, agora é possivel implementar um construtor concreto, como nos exemplos a seguir:

```java
public class KingBuilder implements BoardPieceBuilder {
    private PieceHead head;
    private PieceBody body;
    private PieceFeet feet;
    private PieceEquipament equipament;
    private String name;

    public Horse getKing() {
        return new King(head, body, feet, equipament, name);
    }

    @Override
    public void buildHead(PieceHead head){
        this.head = head;
    };

    @Override
    public void buildBody(PieceBody body){
        this.body = body;
    };

    @Override
    public void buildFeet(PieceFeet feet){
        this.feet = feet;
    };

    @Override
    public void buildEquipament(PieceEquipament equipament){
         this.equipament = equipament;
    }; 

    @Override
    public void setName(String name){
        this.name = name;
    }
}
```

```java
public class HorseBuilder implements BoardPieceBuilder {
    private PieceHead head;
    private PieceBody body;
    private PieceFeet feet;
    private PieceEquipament equipament;
    private String name;

    public Horse getHorse() {
        return new Horse(head, body, feet, equipament, name);
    }

    @Override
    public void buildHead(PieceHead head){
        this.head = head;
    };

    @Override
    public void buildBody(PieceBody body){
        this.body = body;
    };

    @Override
    public void buildFeet(PieceFeet feet){
        this.feet = feet;
    };

    @Override
    public void buildEquipament(PieceEquipament equipament){
         this.equipament = equipament;
    }; 

    @Override
    public void setName(String name){
        this.name = name;
    }
}
```

KingBuilder e HorseBuilder fazem o papel de **ConcreteBuilder**, implementando as funções para as respectivas montagens do produto.

Abaixo é possivel ver, respectivamente, as classes que representam os produtos finais de KingBuilder e HorseBuilder.

```java
public class King {
    private final PieceHead head;
    private final PieceBody body;
    private final PieceFeet feet;
    private final PieceEquipament equipament;
    private final MovementType movementType;
    private String name;

    public King(PieceHead head, PieceBody body, PieceFeet feet, PieceEquipament equipament, String name){
        this.head = head;
        this.body = body;
        this.feet = feet;
        this.equipament = equipament;
        this.name = name;

        if(this.equipament == null){
            this.equipament = new NoEquipament();
        }

        if(this.equipament instanceof NoEquipament){
            this.movementType = new DefaultMovementType(this.body, this.feet, 'King');
        }else{
            this.movementType = new KingMovementType(this.head, this.feet, this.equipament);
        } 

        if(this.name.isEmpty()){
            this.name = getGeneratedName();
        }      
    }

    
    public String getGeneratedName(){
        return 'King Skeleton With Magic Staff';
        //Representação de um nome gerado 
    }

    public PieceHead getHead(){
        return head;
    }

    public PieceBody getBody(){
        return body;
    }

    public PieceFeet getFeet(){
        return feet;
    }

    public PieceEquipament getEquipament(){
        return equipament;
    }

    public MovementType getMovementType(){
        return movementType;
    }

    public setName(String name){
        this.name = name;
        
        if(this.name.isEmpty()){
            this.name = getGeneratedName();
        }
    }

}
```


```java
public class Horse {
    private final PieceHead head;
    private final PieceBody body;
    private final PieceFeet feet;
    private final PieceEquipament equipament;
    private final MovementType movementType;
    private String name;

    public Horse(PieceHead head, PieceBody body, PieceFeet feet, PieceEquipament equipament, String name){
        this.head = head;
        this.body = body;
        this.feet = feet;
        this.equipament = equipament;
        this.name = name;

        if(this.equipament == null){
            this.equipament =  new NoEquipament();
        }

        if(this.equipament instanceof NoEquipament){
            this.movementType = new DefaultMovementType(this.body, this.feet, 'Horse');
        }else{
            this.movementType = new HorseMovementType(this.feet, this.equipament);
        } 

        if(this.name.isEmpty()){
            this.name = getGeneratedName();
        }
            
    }

    public String getGeneratedName(){
        return 'Cyclope With Lance';
        //Representação de um nome gerado 
    }

    public PieceHead getHead(){
        return head;
    }

    public PieceBody getBody(){
        return body;
    }

    public PieceFeet getFeet(){
        return feet;
    }

    public PieceEquipament getEquipament(){
        return equipament;
    }

    public MovementType getMovementType(){
        return movementType;
    }

    public setName(String name){
        this.name = name;
        
        if(this.name.isEmpty()){
            this.name = getGeneratedName();
        }
    }

}
```

Com os participantes Builders e ConcreteBuilders prontos, assim como seus Produtos, agora é possivel implementar O Director responsável por direcionar a solicitação do cliente para a execução correta da montagem das peças, como no exemplo abaixo:

```java
public interface BoardPieceDirector {
   
    public void constructHumanWithSword(BoardPieceBuilder builder){
        builder.buildHead(PieceHead.HUMAN);
        builder.buildBody(PieceBody.FLESH);
        builder.buildFeet(PieceFeet.BIPEDS);
        builder.buildEquipament(new SwordEquipament());
    }

    public void constructLizardWithShield(BoardPieceBuilder builder){
        builder.buildHead(PieceHead.LIZARD);
        builder.buildBody(PieceBody.SCALES);
        builder.buildFeet(PieceFeet.BIPEDS);
        builder.buildEquipament(new ShieldEquipament());
    } 

    public void constructRobotWithGun(BoardPieceBuilder builder){
        builder.buildHead(PieceHead.ROBOT);
        builder.buildBody(PieceBody.METALIC);
        builder.buildFeet(PieceFeet.TANK_TREAD);
        builder.buildEquipament(new GunEquipament());
    }

}
```

Este director é responsavel por construir as peças padrões do jogo, útil para guiar os builders sobre o que fazer e quando fazer.

Após toda a implementação, a utilização no código cliente seria:

```java
public class Client {

    public static void main(String[] args) {
        BoardPieceDirector director = new BoardPieceDirector();
        
        //Assim como no exemplo de implementação anterior,
        //Director (BoardPieceDirector) usa o objeto KingBuilder dado pelo cliente.
        //Isto porque o código cliente sabe qual o builder correto a ser utilizado para gerar um produto especifico.

        KingBuilder kingBuilder = new KingBuilder();
        director.constructHumanWithSword(kingBuilder);

        //O produto final é retornado pela instância de builder (neste caso, KingBuilder), 
        //já que director não enxerga e não depende de KingBuilder e seu produto final.
        King kingProduct = kingBuilder.getKing();

        //outros Builders..

        HorseBuilder horseBuilder = new HorseBuilder();
        director.constructLizardWithShield(horseBuilder);

        Horse horseProduct = horseBuilder.getHorse();
    }
}
```
  
## Usos conhecidos

**Project Lombok** é uma blibioteca Java que utiliza Annotations para gerar código automatico de Builders para classes, facilitando a implementação de construtores e automatizando tarefas repetitivas, como implementar getters e setters para todas as classes.. [^ProjectLombok].

## Padrão relacionados
[Composite](/XX_Composite.md): Como já citado anteriormente, O padrão Composite é geralmente utilizado junto ao Composite devido a praticidade ao criar objetos complexos.

[Factory Method](/XX_Factory_Method.md): Muitos projetos começam com o Factory method por ser mais simples e depois evoluem para o Builder por ser mais flexivel (apesar de ser mais complexo).

[Singleton](/XX_Singleton.md): Construtores Builder também podem ser implementados como Singletons.

## Referências

@include(../bib/bib.md)
