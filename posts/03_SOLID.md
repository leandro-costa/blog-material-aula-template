---
icon: edit
date: 2023-04-04 20:10:00.00 -3
tag:
  - solid
category:
  - aula
order: 3
---

# Princípios SOLID

Adaptado de [^JoaoRobertoSOLID].

SOLID são cinco princípios da programação orientada a objetos que facilitam no desenvolvimento de softwares, tornando-os fáceis de manter e estender. Esses princípios podem ser aplicados a qualquer linguagem de Programação Orientada a Objetos.

Michael Feathers criou esse  acrônimo após observar cinco princípios da orientação a objetos e design de código criados por Robert C. Martin (a.k.a. Uncle Bob) e abordados no artigo The Principles of OOD


S.O.L.I.D: Os 5 princípios da POO
1. S — Single Responsiblity Principle (Princípio da responsabilidade única)
1. O — Open-Closed Principle (Princípio Aberto-Fechado)
1. L — Liskov Substitution Principle (Princípio da substituição de Liskov)
1. I — Interface Segregation Principle (Princípio da Segregação da Interface)
1. D — Dependency Inversion Principle (Princípio da inversão da dependência)

Esses princípios ajudam o programador a escrever códigos mais limpos, separando responsabilidades, diminuindo acoplamentos, facilitando na refatoração e estimulando o reaproveitamento do código.

## Princípio da Responsabilidade Única (SRP)

Adaptado de [^RobsonSRP] e [^JoaoRobertoSOLID].

Este princípio nada mais é do que uma perspectiva diferente para um dos mais fundamentais princípios da orientação a objetos: a coesão.

Esse princípio declara que uma classe deve ser especializada em um único assunto e possuir apenas uma responsabilidade dentro do software, ou seja, a classe deve ter uma única tarefa ou ação para executar.

::: tip Princípio da Responsabilidade Única
Uma classe deve ter um, e somente um, motivo para mudar.
:::

Vamos tentar entender o que isso significa e eventuais problemas causados pela violação deste princípio.

### Alguns Problemas


Quando estamos aprendendo programação orientada a objetos, sem sabermos, damos a uma classe mais de uma responsabilidade e acabamos criando classes que fazem de tudo (*God Class*). Num primeiro momento isso pode parecer eficiente, mas como as responsabilidades acabam se misturando, quando há necessidade de realizar alterações nessa classe, será difícil modificar uma dessas responsabilidades sem comprometer as outras. Toda alteração acaba sendo introduzida com um certo nível de incerteza em nosso sistema — principalmente se não existirem testes automatizados!

Alguns problemas decorrentes da utilização de *God Class*:

- Dificuldade de compreensão e, portanto, dificuldade de manutenção.
- Dificuldade de reuso.
- Com responsabilidades entrelaçadas em uma mesma classe, pode ficar difícil alterar uma dessas responsabilidades sem comprometer as outras (rigidez) e pode acabar quebrando outras partes do software (fragilidade).
- Acoplamento alto, ou seja, a classe tem um número excessivo de dependências, e portanto fica mais sujeita a mudanças em decorrência de alterações em outras classes (novamente a fragilidade).

### Exemplos Comuns de Violação

Imaginem uma classe de negócio Pedido:

```java
public class Pedido{
    public void adicionarProduto(Produto produto, int quantidade){}
    public double calcularTotal(){}
    public void gerarPlanilhaExcel(){}
}
```

No exemplo acima, temos uma quebra do SRP de uma forma bem explícita, uma vez que temos responsabilidades que deveriam ser de componentes distintos do software. Enquanto os dois primeiros métodos fazem sentido para o domínio do qual Pedido faz parte, o último está relacionado à exibição de dados em um formato específico, o que faz mais sentido em camadas superiores, como de Aplicação ou de UI.

Em um projeto com várias classes seguindo esse “padrão”, fica difícil – ou impossível – manter a coesão em um nível mais alto: em nível de componentes. Em outras palavras, o software acaba sendo um emaranhado de classes sem um divisão clara de camadas.

De forma mais prática: chega um momento onde fica impossível separar determinadas classes em uma class library devido à referência circular. Também fica complicado fazer o deploy de componentes isolados por haver dependências demais entre eles.

Outros exemplos comuns são: 
  1. Classes que misturam negócio e persistência (Pedido, por exemplo, contém métodos que sabem incluir, alterar e excluir pedidos, fazendo com o que mesmo seja acoplado com classes como SqlConnection ou ainda algum ORM); 
  1. *View models* que apresentam regras de negócio;

### Um Exemplo Menos Óbvio

Nem sempre é fácil identificar várias responsabilidades em uma mesma classe. Eu diria que na maioria das vezes não é. Aliás, atribuir responsabilidades é uma das principais tarefas de um programador OO.

Mesmo que uma classe de negócio esteja fazendo apenas tarefas relacionadas ao seu domínio, ela pode estar fazendo coisas demais.

Vejamos o seguinte exemplo:
```java
public class Cliente{
    // dados do cliente, como Nome, CPF, etc.
    // outros métodos
 
    public double calcularDescontoPara(Venda venda)    {
        if (FormaDePagamento.AVista.equals(venda.getFormaDePagamento()){
            if (venda.getTotal() > 2000)
                return venda.getTotal() * 0.2;
            return venda.getTotal() * 0.1;
        }
        return 0;
    }
}
```
Observem acima que o método `calcularDescontoPara` não manipula nenhum dado da classe `Cliente`, ou seja, nenhuma informação do cliente é necessária para se determinar o valor do desconto.

Sendo assim, esta classe possui pelo menos duas razões para mudar: uma quando houver alteração na lógica de negócio referente a um `Cliente` e outra quando houver alguma alteração na lógica de uma `Venda`.

Certamente, faz mais sentido que este método seja da classe `Venda`!

### Outro exemplo

```java
public class Order{
    public double calculateTotalSum(){/*...*/}
    public List<Item> getItems(){/*...*/}
    public int getItemCount(){/*...*/}
    public void addItem(Item item){/*...*/}
    public void deleteItem(Item item){/*...*/}

    public void printOrder(){/*...*/}
    public void showOrder(){/*...*/}

    public void load(){/*...*/}
    public void save(){/*...*/}
    public void update(){/*...*/}
    public void delete(){/*...*/}
}
```

A classe `Order` viola o SRP porque realiza 3 tipos distintos de tarefas. Além de lidar com as informações do pedido, ela também é responsável pela exibição e manipulação dos dados. Lembre-se, o princípio da responsabilidade única preza que uma classe deve ter um, e somente um, motivo para mudar.

A violação do _Single Responsibility Principle_ pode gerar alguns problemas, sendo eles:
- Falta de coesão — uma classe não deve assumir responsabilidades que não são suas;
- Alto acoplamento — Mais responsabilidades geram um maior nível de dependências, deixando o sistema engessado e frágil para alterações;
- Dificuldades na implementação de testes automatizados — É difícil de "mockar" esse tipo de classe;
- Dificuldades para reaproveitar o código;
Aplicando o SRP na classe Order, podemos refatorar o código da seguinte forma:

```java
public class Order{
    public double calculateTotalSum(){/*...*/}
    public List<Item> getItems(){/*...*/}
    public int getItemCount(){/*...*/}
    public void addItem(Item item){/*...*/}
    public void deleteItem(Item item){/*...*/}
}

public class OrderRepository{
    public Order load(double orderId){/*...*/}
    public Order save(Order order){/*...*/}
    public Order update(Order order){/*...*/}
    public void delete(Order order){/*...*/}
}

public class OrderViewer{
    public void printOrder(Order order){/*...*/}
    public void showOrder(Order order){/*...*/}
}
```

Perceba no exemplo acima que agora temos 3 classes, cada uma cuidando da sua responsabilidade.

O princípio da responsabilidade única não se limita somente a classes, ele também pode ser aplicado em métodos e funções, ou seja, tudo que é responsável por executar uma ação, deve ser responsável por apenas aquilo que se propõe a fazer.


### Conclusão

O SRP é um dos princípios mais importantes que existe na orientação a objetos. Quando falamos de responsabilidades e coesão estamos tocando em dois pontos-chave da OO, que nos ajudam a criar classes menores, de mais fácil entendimento, manutenção e reuso.


## Princípio Aberto-Fechado (OCP)

Adaptado de [^RobsonOCP] e [^JoaoRobertoSOLID].

O OCP é mais um daqueles princípios de orientação a objetos que nos ajudam a eliminar *design smells,* possibilitando que nosso código ganhe em facilidade de manutenção e extensão.

::: tip Princípio Aberto-Fechado
Entidades de software (classes, módulos, funções, etc.) devem ser abertas para extensão mas fechadas para modificação.
:::

A moral da história é a seguinte: quando eu precisar estender o comportamento de um código, eu crio código novo ao invés de alterar o código existente.

Objetos ou entidades devem estar abertos para extensão, mas fechados para modificação, ou seja, quando novos comportamentos e recursos precisam ser adicionados no software, devemos estender e não alterar o código fonte original.

### Exemplo prático do OCP:
Em um sistema hipotético de RH, temos duas classes que representam os contratos de trabalhos dos funcionários de uma pequena empresa, contratados e estagiários. Além de uma classe para processar a folha de pagamento.

```java
public class ContratoClt{
    public double salario(){
        //...
    }
}

public class Estagio{
    public double bolsaAuxilio(){
        //...
    }
}

public class FolhaDePagamento{
    private double saldo;
    
    public double calcular(ContratoClt contratoClt  ){
        this.saldo = contratoClt.salario();
    }
    public double calcular(Estagio estagio ){
        this.saldo = estagio.bolsaAuxilio();
    }
}
```

A classe `FolhaDePagamento` precisa verificar o funcionário para aplicar a regra de negócio correta na hora do pagamento. Supondo que a empresa cresceu e resolveu trabalhar com funcionários PJ, obviamente seria necessário modificar essa classe! Sendo assim, estaríamos quebrando o princípio Aberto-Fechado do SOLID.


Qual o problema de se alterar a classe FolhaDePagamento?

Não seria mais fácil apenas acrescentar mais um IF (ou criar um novo método) e verificar o novo tipo de funcionário PJ aplicando as respectivas regras? Sim, e provavelmente essa seria a solução que programadores menos experientes iriam fazer. Mas, esse é exatamente o problema! *Alterar uma classe já existente para adicionar um novo comportamento, corremos um sério risco de introduzir bugs em algo que já estava funcionando.*

::: tip Lembre-se
OCP preza que uma classe deve estar fechada para alteração e aberta para extensão.
:::


Como adicionamos um novo comportamento sem alterar o código fonte já existente?

O guru Uncle Bob resumiu a solução em uma frase:

> Separate extensible behavior behind an interface, and flip the dependencies.

Em tradução direta, seria:

> Separe o comportamento extensível por trás de uma interface e inverta as dependências.

O que devemos fazer é concentrar nos aspectos essências do contexto, abstraindo-os para uma interface. Se as abstrações são bem definidas, logo o software estará aberto para extensão.

### Aplicando OCP na prática

Voltando para o nosso exemplo, podemos concluir que o contexto que estamos lidando é a remuneração dos contratos de trabalho, aplicando as premissas de se isolar o comportamento extensível atrás de uma interface, podemos criar uma interface com o nome `Remuneravel` contendo o método `remuneracao()`, e fazer com que nossas classes de contrato de trabalho implementem essa interface. Além disso, iremos colocar as regras de calculo de remuneração para suas respectivas classes, dentro do método `remuneracao()`, fazendo com que a classe `FolhaDePagamento` dependa somente da interface `Remuneravel` que iremos criar.

Veja o código refatorado abaixo:

```java

public interface Remuneravel{
    public double remuneracao();
}

public class ContratoClt implements Remuneravel{
    public double remuneracao(){
        return salario();
    }
}

public class Estagio implements Remuneravel{
    public double remuneracao(){
        return bolsaAuxilio();
    }
}

public class FolhaDePagamento{
    protected double saldo;
    
    public double calcular(Remuneravel funcionario){
        this.saldo = funcionario.remuneracao();
    }
}
```

Agora a classe `FolhaDePagamento` não precisa mais saber quais métodos chamar para calcular. Ela será capaz de calcular o pagamento corretamente de qualquer novo tipo de funcionário que seja criado no futuro (`ContratoPJ`) — desde que ele implemente a interface `Remuneravel` — sem qualquer necessidade de alteração do seu código fonte. Dessa forma, acabamos de implementar o princípio de Aberto-Fechado do SOLID em nosso código!

Open-Closed Principle também é base para o padrão de projeto Strategy

### Outro Exemplo de violação (OCP)

```java
public class Arquivo{
}
 
public class ArquivoWord extends Arquivo{
    public void gerarDocX(){
        // codigo para geracao do arquivo
    }
}
 
public class ArquivoPdf extends Arquivo{
    public void gerarPdf(){
        // codigo para geracao do arquivo
    }
}
 
public class GeradorDeArquivos{
   public void gerarArquivos(List<Arquivo> arquivos){
      for(Arquivo arquivo : arquivos){
         if (arquivo instanceof ArquivoWord){
            ((ArquivoWord)arquivo).gerarDocX();
         }else if (arquivo instanceof ArquivoPdf){
            ((ArquivoPdf)arquivo).gerarPdf();
         }
      }
   }
}
```

No exemplo acima temos classes que geram arquivos do Word e PDFs. E temos uma classe `GeradorDeArquivos` que recebe uma lista de arquivos e gera todos eles (por _gerar_, entenda criar um arquivo novo no formato especificado e salvá-lo em disco).

Suponha agora que tenhamos que estender a aplicação para dar suporte a arquivos em outro formato, como, por exemplo, arquivos texto (.txt) e precisamos que o método `gerarArquivos` também gere arquivos no novo formato.

Além da nova classe, que poderíamos chamar de `ArquivoTxt`, seríamos obrigados a alterar o método `gerarArquivos` para atender a esse requisito. O mais óbvio seria colocar mais um `else if`, checando pelo novo tipo (txt) e chamando o método correspondente: `((ArquivoTxt)arquivo).gerarTxt()`. Esse padrão seguiria sucessivamente a cada necessidade de um novo formato de arquivo.

Sendo assim, podemos afirmar que o método `gerarArquivos` não está em conformidade com o OCP para mudanças do tipo _preciso de um novo formato de arquivo_, uma vez que o método não está fechado para essas mudanças.

Vamos pensar na situação onde existam outras partes da aplicação que também fazem as verificações por tipo vistas no método `gerarArquivos` para invocar outros métodos específicos de cada classe concreta. Para piorar, algumas dessas partes estão em outros componentes da aplicação.

O que acontece quando precisamos de um novo formato de arquivo?

Além de criarmos nosso novo arquivo, como `ArquivoTxt`, teríamos que:

1. Alterar todos os métodos que precisem fazer uso do novo formato (certamente aqueles com vários `if/else if` ou um belo `switch..case`).
1. Recompilar e fazer o deploy de todos os componentes que foram impactados.

Quando uma mudança dessas acaba causando uma série de mudanças em cascata, fica claro que nosso design não está bom pois, além de mais trabalho para alterarmos, ainda podemos nos esquecer de algumas dessas partes do código.

Além disso, quanto mais código para alterar, que já estava pronto e funcionando, mais chances de introduzir bugs.

#### Atendendo OCP

para atender o OCP o código poderia ser alterado da seguinte forma:

```java

public abstract class Arquivo{
    public abstract void gerar();
}
 
public class ArquivoWord extends Arquivo{
    @Override
    public void gerar(){
        // codigo para geracao do arquivo
    }
}
 
public class ArquivoPdf extends Arquivo{
    @Override
    public void gerar(){
        // codigo para geracao do arquivo
    }
}
 
public class ArquivoTxt extends Arquivo{
    @Override
    public void gerar(){
        // codigo para geracao do arquivo
    }
}
 
public class GeradorDeArquivos{
   public void gerarArquivos(IList<Arquivo> arquivos){
      for(Arquivo arquivo : arquivos){
        arquivo.gerar();
      }
   }
}
```

Algumas pequenas mudanças foram realizadas para melhorar a estruturação do código:

1. A classe `Arquivo` foi transformada em uma classe abstrata, já que não há a intenção de instanciá-la diretamente.
2. Foi criado um método abstrato para a geração de arquivos na classe base, denominado de `gerar`.
3. As classes derivadas foram modificadas para implementar o método `gerar`.
4. Um novo requisito foi introduzido, ou seja, um novo tipo de arquivo (`ArquivoTxt`), que também herda da classe `Arquivo` e implementa o método `gerar`.
5. As verificações de tipo presentes no método `gerarArquivos` foram eliminadas e o polimorfismo foi utilizado em seu lugar.

Em resumo, agora sempre que um novo formato de arquivo surgir, é possível estender o comportamento do método `gerarArquivos` para lidar com ele, sem a necessidade de modificá-lo. Basta criar o novo tipo de arquivo e ele estará pronto para ser gerado. Simples e eficiente!

### Conclusão

O Princípio do Aberto/Fechado nos atenta para a aplicação de abstrações e polimorfismo, de forma consciente, garantindo que tenhamos um software mais flexível e, portanto, mais fácil de ser mantido.

## Princípio da substituição de Liskov

[^STACKIFY_LSP]

O Princípio de Substituição de Liskov é uma ferramenta essencial para a identificação de conceitos semelhantes sendo representados por classes diferentes. Ele é baseado na ideia de que uma classe derivada deve ser capaz de substituir sua classe base sem afetar o comportamento do programa. Isso significa que, se um programa pode utilizar objetos de tipos diferentes de maneira intercambiável, então esses objetos deveriam ser de classes que possuem uma relação de herança.

Ao aplicar o LSP, os desenvolvedores podem garantir que suas classes derivadas respeitem as mesmas regras e comportamentos que suas classes base. Isso ajuda a manter a coerência e consistência do código, bem como a facilitar a manutenção e a evolução do software.

Por exemplo, imagine que um programa possui uma classe `Forma` que representa a forma geométrica básica e dela são derivadas duas outras classes `Retângulo` e `Triângulo`. Se o programa tem uma função que calcula a área de uma forma, é importante que essa função funcione de maneira consistente para todas as formas, independentemente de serem retângulos ou triângulos.

Imagine agora que o sistema possui uma classe `Circulo` e essa classe não faça parte da família `Forma`. Durante a execução do programa o comportamento de `Circulo` é muito semelhante aos dos filhos de `Forma`. `Circulo` pode ser desenhado na tela, ter suas características de tamanho e cor alteradas e ter uma formula para o calculo de area. Assim como os objetos da família `Circulo`.

### Definição

O Princípio de Substituição de Liskov leva esse nome por ter sido criado por Barbara Liskov, em 1988. A definição formal de Liskov diz que:

::: tip Definição
Se para cada objeto `o1` do tipo `S` há um objeto `o2` do tipo `T` de forma que, para todos os programas `P` definidos em termos de `T`, o comportamento de `P` é inalterado quando `o1` é substituído por `o2` então `S` é um subtipo de `T`
:::



## Princípio da Segregação de Interface (ISP)

[^JACKHISTON] [^MACORATTI_ISP]


## O que é uma interface?

Uma interface define um contrato que uma classe deve seguir, especificando quais métodos ela deve implementar. Quando `Cliente` deseja interagir com `ServicoA`, v se comunicará por meio da interface `Servico`, para a qual `ServicoA` e `Cliente` se entendem mutuamente.

<figure>

```plantuml
class Cliente
class ServicoA implements Servico 

Cliente . Servico 
```

<figcaption>Uso de interface pela classe Cliente</figcaption>
</figure>

Interfaces são úteis para polimorfismo. o objeto `Cliente` apenas entende ou sabe sobre a interface `Servico`, o que significa que ele não sabe que o objeto `ServicoA` existe. Isso significa que pode ocorrer polimorfismo - ou seja, o objeto `Servico` pode ser substituído por muitas implementações diferentes, sem afetar o objeto `Cliente`

## Definição

O Princípio da Segregação de Interface trata da coesão de interfaces e diz que 

::: tip Definição
Clientes não devem ser forçados a depender de métodos que não usam.
:::

Este princípio afirma que os clientes não devem ser forçados a depender das interfaces que eles não usam. Quando temos interfaces não coesas, o ISP nos orienta a criar múltiplas interfaces menores e coesas.


::: warning 
Coesão é o nível de integralidade interna de uma classe e mede o grau em que uma classe ou seus métodos fazem sentido, ou seja, quão claro é o entendimento do que a classe ou método possui. Uma alta coesão indica responsabilidades bem definidas.
::: 

Quando você aplica o ISP, a classe e suas dependências se comunicam usando interfaces fortemente focadas, minimizando as dependências de membros não utilizados e reduzindo o acoplamento de acordo.

Interfaces menores são mais fáceis de implementar, melhorando a flexibilidade e a possibilidade de reutilização. Como menos classes compartilham interfaces, o número de alterações necessárias em resposta a uma modificação da interface é reduzido, e, isso aumenta a robustez.

```java
   public interface Pedido{
        void compra();
        void processarCartaoCredito();
    }

    public class PedidoOnline implements Pedido{
        public void compra(){
            //código da compra
        }
        public void processarCartaoCredito(){
            //processo do cartão
        }
    }

    public class PedidoPresencial implements Pedido{
        public void compra(){
            //código da compra
        }
        public void processarCartaoCredito(){
            //Não precisa para boleto
            throw new UnsupportedOperationException();
        }
    }
```

Neste código temos a interface `Pedido` sendo implementada pelas classes PedidoOnline e `PedidoPresencial`.

Aparentemente tudo esta correto e o código vai funcionar.

Mas este código esta violando o princípio ISP pois a interface `Pedido` esta sendo implementada pela classe `PedidoPresencial` mas esta classe não esta implementando o método `ProcessarCartaoCredito`.

Assim a classe esta sendo forçada a depender do método `ProcessarCartaoCredito` que ela não precisa usar.

Para adequar o código ao princípio ISP podemos fazer assim:


```java
   public interface Pedido{ 
        void compra();
    }
   public interface PagamentoCartao{
        void processarCartaoCredito();
    }

    public class PedidoOnline implements Pedido, PagamentoCartao{
        public void compra(){
            //código da compra
        }
        public void processarCartaoCredito(){
            //processo do cartão
        }
    }

    public class PedidoPresencial implements Pedido{
        public void compra(){
            //código da compra
        }        
    }
```

Agora temos interfaces específicas `Pedido` e `PagamentoCartao`, e, nenhuma classe esta sendo obrigada a implementa um método que não utiliza.


## Princípio da Inversão de Dependência (DIP)

[^MACORATTI_DIP]

::: tip Definição

- Dependa de abstrações e não de implementações
- Módulos de alto nível não devem depender de módulos de baixo nível. Ambos devem depender de abstrações
- Abstrações não devem depender de detalhes. Detalhes devem depender de abstrações

:::

que, basicamente significam *Programe para uma interface/classe abstrata e não para uma classe concreta*.



A dependência em tempo de compilação da maioria dos aplicativos flui na direção da execução do runtime, o que resulta em um gráfico de dependência direta. Por exemplo, se um módulo A chama uma função/método no módulo B, que por sua vez chama uma função/método no módulo C, então em tempo de compilação, A dependerá de B, que dependerá de C, criando uma cadeia de dependência como mostrado abaixo:

<figure>

```plantuml
package "Tempo de compilação" {
    class ClassA
    class ClassB 
    class ClassC 
    ClassA ..>  ClassB :"  Referência"   
    ClassB ..> ClassC :"  Referência"    
    

}

package "Tempo de execução" {
    class ClassA 
    class ClassB 
    class ClassC 
    ClassA ..>  ClassB :"  Controle de Fluxo"   
    ClassB ..> ClassC :"  Controle de Fluxo" 
}

```

<figcaption>Dependência direta</figcaption>
</figure>

A aplicação do princípio de inversão de dependência permite que a `ClasseA` chame métodos em uma abstração implementada por `ClasseB`, possibilitando que `ClasseA` chame `ClasseB` em tempo de execução, mas que `ClasseB` dependa de uma interface controlada por `ClasseA` em tempo de compilação (invertendo assim a dependência em tempo de compilação).

Em tempo de execução, o fluxo de execução do programa permanece inalterado, mas a introdução de interfaces significa que diferentes implementações dessas interfaces podem ser facilmente conectadas.

<figure>

```plantuml

package "Tempo de compilação" {
    class ClassA
    class ClassB 
    interface InterfaceB
    class ClassC 
    interface InterfaceC
    ClassA ..  InterfaceB :"  Referência"   
    InterfaceB <|. ClassB
    InterfaceC <|. ClassC
    InterfaceB -[hidden]- InterfaceC
    ClassB ..  InterfaceC :"  Referência"   

}

package "Tempo de execução" {
    class ClassA 
    class ClassB 
    class ClassC 
    ClassA -->  ClassB :"  Controle de Fluxo"   
    ClassB --> ClassC :"  Controle de Fluxo" 
}
```

<figcaption>Inversão da Dependência</figcaption>
</figure>


Assim a inversão de dependência é uma parte essencial da construção de aplicativos fracamente acoplados, pois os detalhes da implementação podem ser escritos para depender e implementar abstrações de nível superior, e não o contrário.

Os aplicativos resultantes são mais testáveis, modulares e sustentáveis como resultado.

Os principais motivos para programar para uma interface/classe abstrata são:

- *Facilidade de manter o código*  - As alterações ficam mais isoladas, não precisa mudar tudo que aceitava uma classe concreta para aceitar outra necessária. È possível mudar a implementação sem quebrar a aplicação.
- *Fica fácil estender o código* - Permite que novas implementações sejam feitas sem alterar tudo que esperava determinado objeto; certos comportamentos se tornam mais genéricos podendo manipular objetos que ele desconhece desde que contenha o contrato esperado;
- *Fica mais fácil realizar testes* - É fácil substituir um objeto real de produção por um falso que facilite o teste;

Além disso interfaces facilitam a redução do acoplamento do código e ajudam a encapsular o código.

### Como podemos obter a inversão da dependência?

Uma das formas de obter a inversão da dependência e usar o padrão de projeto da injeção da dependência. Dessa forma injetamos a dependência para obter a inversão da dependência.

Como exemplo temos Jakarta Contexts and Dependency Injection (CDI) que é um framework para injeção de dependência em Java. Ele fornece um conjunto de anotações e uma infraestrutura para criar e gerenciar objetos de maneira mais fácil e flexível. O CDI é parte da especificação Jakarta EE.

Outras opções são de CDI em java são:

- *Spring Framework*: é uma das alternativas mais populares ao CDI, oferecendo injeção de dependência, controle transacional, gerenciamento de segurança, entre outras funcionalidades. O Spring possui uma comunidade grande e ativa, além de uma ampla documentação.
- *Google Guice*: é um framework de injeção de dependência leve e fácil de usar, que utiliza anotações para definir as dependências entre classes. O Guice foi criado pela Google e é usado em alguns projetos internos da empresa.
- *PicoContainer*: é um framework de injeção de dependência que oferece uma solução simples e eficiente para gerenciamento de objetos. O PicoContainer é leve e fácil de usar, e permite a criação de aplicativos modulares e escaláveis.

## Referências

<!-- @include: ../bib/bib.md -->