---
icon: edit
date: 2023-04-20 20:10:00.00 -3
tag:
  - Prototype
  - gof
category:
  - aula
order: 10
excerpt: Apresentação do Padrão de Projeto Prototype
---

# Prototype (GOF)

## Intenção

Especificar os tipos de objetos a serem criados usando uma instância-protótipo e criar novos objetos pela cópia desse protótipo.

## Também conhecido como

Clone ou clonagem de objetos.

## Motivação

Para um programa de cadastro de clientes, é importante que existam diferentes formas de realizar o cadastro de cada tipo de cliente, levando em conta que alguns clientes podem exigir mais informações do que outros. Nesse contexto, a utilização do Padrão Prototype pode ser uma solução adequada, uma vez que permite criar uma interface com as informações que precisam ser coletadas do cliente. Com esse padrão, é possível adicionar ou remover atributos conforme as necessidades do cliente, tornando o processo de cadastro mais flexível e adaptável às particularidades de cada tipo de cliente. Por exemplo, se um paciente precisar fornecer informações adicionais, é possível acrescentar novos atributos sem comprometer a estrutura original da interface.

```java

// Interface que define o comportamento do protótipo

interface Prototype {
    Prototype clone();
}

// Classe que implementa o protótipo

class Pessoa implements Prototype {
    private String nome;
    private int idade;
    private String sexo;

    public Pessoa(String nome, int idade, String sexo) {
        this.name = nome;
        this.age = idade;
        this.sexo = sexo;
    }

    // Implementação do método clone

    public Prototype clone() {
        return new Person(nome, idade, sexo);
    }

    // Outros métodos da classe Pessoa

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}

// Cliente que usa o padrão Prototype

class Cliente {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Luís", 19, "Masculino");
        Pessoa pessoa2 = (Pessoa) pessoa1.clone();

        // Operações com o clone
        System.out.println(pessoa1.getName()); //Luís
        System.out.println(pessoa2.getName()); //Luís
    }
}
```

O padrão Prototype declara uma interface comum para todos os objetos que suportam a clonagem, no caso o processo de clonagem é delegado pelo padrão para o objeto que está sendo clonado. Essa interface permite que você clone um objeto sem acoplar seu código à classe daquele objeto. Geralmente, tal interface contém apenas um único método clonar. A implementação do método clonar é muito parecida em todas as classes. O método cria um objeto da classe atual e carrega todos os valores de campo para do antigo objeto para o novo.

## Aplicabilidade

Use o padrão Prototype quando um sistema tiver que ser independente de como os seus produtos são criados, compostos e representados; e
- quando as classes a instanciar forem especificadas em tempo de execução, por exemplo, por carga dinâmica; ou
- para evitar a construção de uma hierarquia de classes de fábricas paralela à hierarquia de classes de produto; ou
- quando as instâncias de uma classe puderem ter uma dentre poucas combinações diferentes de estados. Pode ser mais conveniente instalar um número correspondente de protótipos e cloná-los, ao invés de instanciar a classe manualmente, cada vez com um estado apropriado; ou
- quando o objeto for caro, no sentido de complexos para serem construídos ou caros computacionalmente.

## Estrutura

<figure>


@startuml
class Client {
  Operation()
}
interface Prototype {
  Clone()
}
class ConcretPrototype1 {
  Clone()
}
class ConcretPrototype2 {
  Clone()
}      

Client - Prototype : prototype
class Client 
note bottom: p = prototype->Clone() 

Prototype <|--- ConcretPrototype1 
Prototype <|--- ConcretPrototype2 

class ConcretPrototype1 
note bottom: Retorna a cópia de si mesmo
class ConcretPrototype2 
note bottom: Retorna a cópia de si mesmo
@enduml

 - **Client** - é o código fora da estrutura do Prototype, que deseja clonar o objeto protótipo.
 - **Prototype** - uma interface para garantir que todos os objetos protótipo tenham o método "clone".
 - **ConcretePrototype1|2** - são objetos protótipos. 

<figcaption>Estrutura Prototype.</figcaption>
</figure>


## Participantes

- **Prototype** (Prototype)
    - declara uma interface para clonar a si próprio.
- **ConcretePrototype** (Pessoa)
    - implementa uma operação para clonar a si próprio
- **Client** (Cliente)
    - cria um novo objeto solicitando a um protótipo que clone a si próprio.

## Colaborações

-  Um cliente solicita a um protótipo que este clone a si próprio.

## Consequências

O padrão Prototype tem os seguintes benefícios e desvantagens:

1. **Acrescenta e remove produtos em tempo de execução.** O cliente pode instalar e remover protótipos em tempo de execução, isso o torna mais flexível do que outros padrões. 
2. **Ele isola as classes concretas.** Os clientes manipulam as instâncias através das interfaces abstratas, pois o cliente é isolado das classes de implementação.
3. **Especifica novos objetos pela variação de valores.** O cliente pode exibir um novo comportamento através da delegação de responsabilidades para o protótipo. Pois você define novos tipos de objetos pela instanciação das classes existentes e registrando as instâncias como protótipos dos objetos-clientes.
4. **Especifica novos objetos pela variação da estrutura.** Muitas aplicações constróem objetos com partes e subpartes. Por exemplo, editores para o projeto de circuitos que constroem circuitos a partir de subcircuitos. Com esse formato ao realizar o clone dos circuitos, os valores dos subcircuitos não serão alterados e se forem os valores vão ser alterados em todos os clones, gerando incosistencia nos dados. Então é necessário que o objeto-circuito composto implemente um clone por replicação (deep copy), circuitos com diferentes estruturas podem ser protótipos.
5. **Não é necessário ficar criando novos objetos ou utilizar o Factory Method para construir novos objetos.** O padrão Prototype permite que simplismente se crie um clone do protótipo. 
6. **Configura dinamicamente uma aplicação com classes.** Alguns ambientes de tempo de execução permitem carregar classes dinamicamente numa aplicação. Uma aplicação que quer criar instâncias de uma classe dinamicamente carregada não será capaz de referenciar o seu constructor estaticamente. Em vez disso, o ambiente de tempo de execução cria uma instância de cada classe automaticamente, quando carregada, e registra a instância junto a um gerenciador de protótipo.
7. **Campos de objetos privados.** Quando você quer fazer a cópia exata de um objeto, será necessário ir em todos os campos e coletar seus valores para copiar e em alguns casos existem campos privados, que não serão visíveis de fora do objeto.
8. **Depedência da classe.** Ao criar um clone de uma classe, seu código vai se tornar dependente da classe em questão.
9. **Classe concreta desconhecida.** Em algumas ocasiões o cliente vai saber somente da interface em que o objeto segue, sem saber qual a classe concreta em que está se relacionando.

## Implementação

Ao implementar protótipos levam-se em consideração os seguintes aspectos:

1. **Usar um gerenciador de protótipos.** Um gerenciador de protótipos é uma memória associativa que retorna o protótipo correspondente a uma chave fornecida. Ele tem operações para registrar um protótipo com uma chave e para removê-lo do registro. Os clientes podem mudar ou mesmo pesquisar o registro em tempo de execução. Isso permite aos clientes estenderem e fazerem um inventário do sistema sem necessidade de escrever linhas de código.
2. **Implementar a operação Clone.** A parte mais difícil do padrão Prototype é a implementação correta da operação Clone. Ela é particularmente difícil quando as estruturas de objetos contêm referências circulares. Na maioria das vezes utilizar shallow copy é suficiente, porém ao utiliza-lá os apontadores dos endereços serão compartilhados entre a cópia e o original. Já utilizando a deep copy, porém clonar protótipos com estruturas complexas normalmente exige uma cópia por replicação (deep copy), porque o clone e o original devem ser independentes. Portanto, você deve garantir que os componentes do clone são clones dos componentes do protótipo. A clonagem força a decidir o que, se for o caso, será compartilhado.
3. **Iniciar clones.** Enquanto alguns clientes ficam perfeitamente contentes com o clone tal como ele é, outros desejarão iniciar alguns ou todos os seus estados internos com valores de sua escolha. Você geralmente não pode passar esses valores para operação Clone porque o seu número variará entre as classes de protótipo. Alguns protótipos podem necessitar de múltiplos parâmetros de inicialização; outros não necessitarão de nenhum. Passar parâmetros para a operação Clone impede uma interface uniforme de clonagem.

## Exemplo de código

Vários objetos do nosso sistema poderiam ter essa capacidade de clonar. Seria interessante definir uma interface para padronizar e marcar os objetos com essas características.

```java

public interface Prototype<T> {
    T clone();
}

```

Depois, devemos implementar a interface Prototype nas classes que devem possuir a característica que desejamos.

```java

public class Campanha implements Prototype<Campanha> {
    // Atributos e métodos da classe

    public Campanha clone() {
        //Lógica para criar uma cópia da campanha 'this'
    }
}

```

Quando o usuário quiser criar uma campanha com as mesmas configurações de uma campanha já criada, devemos escrever um código semelhante a este:

```java

Campanha campanha1 = ...
Campanha campanha2 = campanha1.clone();
campanha2.setNome("K19 - Campanha de Verão");
campanha2.getAnuncios().get(0).setTitulo("K19 - Padrões de Projeto");
campanha2.getAnuncios().get(0).setTexto("Novo treinamento de Padrões de Projeto da K19");

```

A seguir tem outro exemplo de código em Java, utilizando o padrão Prototype que é usado para utilizar um modelo existente, para que seja clonado em vez de ser criado do zero, economizando rescursos de processamento e simplificando a criação de objetos semelhantes.

A interface Prototype declara um método clone, que deve ser implementado em todas as classes que desejam ser clonáveis.

```java

interface Prototype {
    Prototype clone();
}

```

A classe Quadriláteros implementa a interface Prototype que fornece a implementação para o método clone, que cria uma nova instância da mesma classe com os mesmos valores da instância original.

```java

class Quadrilateros implements Prototype {
    private String name;
    private double ladoA;
    private double ladoB;
    private double ladoC;
    private double ladoD;

    public Quadrilateros(String name, double ladoA, double ladoB, double ladoC, double ladoD) {
        this.name = name;
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
        this.ladoD = ladoD;
    }

    // Implementação do método clone
    public Prototype clone() {
        return new Quadrilateros(name, ladoA, ladoB, ladoC, ladoD);
    }

    // Outros métodos da classe Quadrilateros
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //...
}

```

Na classe Client é utilizada a implementação do objeto Quadrilateros chamado Quadrado, onde ele é clonado para a criação do novo objeto Retangulo.

```java

class Client {
    public static void main(String[] args) {
        Quadrilateros Quadrado = new Quadrilateros("Quadrado", 10, 20, 10, 20);
        Quadrilateros Retangulo = (Quadrilateros) Quadrado.clone();

```

Em seguida é realizada algumas operações com os objetos criados.

```java

    System.out.println(Quadrado.getName()); // Quadrado
    System.out.println(Retangulo.getName()); // Quadrado
    Retangulo.setName("Retângulo");
    System.out.println(Retangulo.getName()); // Retângulo

```

As saídas do programa mostra que os objetos são independentes, com valores de atributos diferentes e podem ser manipulados individualmente, por mais que um seja um clone do outro.

## Usos conhecidos

Talvez o primeiro exemplo do padrão Prototype se encontre no sistema Sketchpad de Ivan Sutherland [Sut63]. A primeira aplicação amplamente conhecida do padrão numa linguagem orientada a objeto foi em ThingLab, na qual os usuários poderiam formar um objeto composto e então promovê-lo a um protótipo pela sua instalação numa biblioteca de objetos reutilizáveis [Bor81]. Goldberg e Robson mencionam protótipos como um padrão [GR83], mas Coplien [Cop92] fornece uma descrição muito mais completa. Ele descreve idiomas relacionados ao padrão prototype para C++ e dá muitos exemplos e variações. O Etgdb é um depurador (debugger) de front-end, baseado em ET++, que fornece uma interface de apontar e clicar para diferentes depuradores orientados a linhas. Cada depurador tem uma subclasse DebuggerAdaptor correspondente. Por exemplo, GdbAdaptor adapta o etgdb à sintaxe dos comandos do gdb de GNU, enquanto que SunDbxAdaptor adapta o etgdb ao depurador da Sun. O Etgdb não tem um conjunto de classes DebuggerAdaptor codificadas rigidamente nele próprio. Em vez disso, lê o nome do adaptor a ser usado de uma variável fornecida pelo ambiente, procura um protótipo com o nome especificado em uma tabela global e, então, clona o protótipo. Novos depuradores podem ser acrescentados ao etgdb ligando-o ao DebuggerAdaptor que funciona para um depurador novo. A “biblioteca de técnicas de interações”, no ModeComposer, armazena protótipos de objetos que suportam várias técnicas de interação [Sha90]. Qualquer técnica de interação criada pelo Mode Composer pode ser usada como um protótipo colocando-a nesta biblioteca. O padrão Prototype permite ao Mode Composer suportar um conjunto ilimitado de técnicas de interação. O exemplo do editor musical discutido anteriormente se baseia no framework para desenhos do Unidraw [VL90].

## Padrão relacionados
[Abstract Factory]: Prototype e Abstract Factory são padrões que competem entre si em várias situações. Um Abstract Factory pode armazenar um conjunto de protótipos a partir dos quais podem ser clonados e retornados objetos-produto.
[Composite e Decorator]: Podem se beneficiar do uso do Prototype.

## Referências

- k19-k51-design-patterns-em-java
- Gamma Erich - Padrões de Projetos - Soluções Reutilizáveis
- Otávio Miranda - Prototype Teoria - Padrões de Projeto - Parte 8/45 - https://youtu.be/Z-_smcjkdwM
- Otávio Miranda - Prototype Prática - Padrões de Projeto - Parte 9/45 - https://youtu.be/NMwokH-kKZE

<!-- @include: ../bib/bib.md -->
