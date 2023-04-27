# ABSTRACT FACTORY

[^GAMMA]

## Intenção

Fornecer uma interface para criação de famílias de objetos relacionados ou dependentes sem especificar suas classes concretas.

## Também conhecido como

Kit

## Motivação

Considere um toolkit para construção de interfaces de usuários que suporte múltiplos
estilos de interação (look-and-feel) tais como o Motif e o Presentation Manager.
Diferentes estilos de interação definem diferentes apresentações e comportamento
para os widgets de uma interface de usuário, tais como barras de rolamento, janelas
e botões. Para ser portátil entre vários estilos de aparência, uma aplicação não deve
codificar rigidamente seus widgets para um determinado padrão. Instanciando
classes específicas de estilo de interação para os widgets pela aplicação toda, torna
difícil mudar o estilo no futuro.
Podemos resolver esse problema definindo uma classe abstrata WidgetFactory
que declara uma interface para criação de cada tipo básico de widget. Existe também
uma classe abstrata para cada tipo de widget, e subclasses concretas implementam os
widgets para interação. A interface de WidgetFactory tem uma operação que retorna
um novo objeto widget para cada classe abstrata de widget. Os clientes chamam estas
operações para obter instâncias de widget, mas não têm conhecimento das classes
concretas que estão usando. Desta forma, os clientes ficam independentes do padrão
de interação usado no momento.

<figure>
<img src="/assets/motive.png">

</figure>

Existe uma subclasse concreta de WidgetFactory para cada estilo de interação.
Cada subclasse implementa as operações para criar o widget apropriado para
aquele estilo de interação. Por exemplo, a operação CreateScrollBar aplicada à
MotifWidgetFactory instancia e retorna uma barra de rolamento de acordo com o
Motif, enquanto que a correspondente operação aplicada à PMWidgetFactory
retorna uma barra de rolamento para o Presentation Manager. Os clientes criam
widgets exclusivamente através da interface de WidgetFactory e não tem conhecimento das classes que implementam os widgets para um padrão em particular. Em
outras palavras, os clientes têm somente que se comprometer com uma interface
definida por uma classe abstrata, não uma determinada classe concreta. Uma
WidgetFactory também implementa e garante as dependências entre as classes
concretas de widgets. Uma barra de rolamento Motif deveria ser usada com um
botão Motif e um editor de textos Motif, e essa restrição é garantida automaticamente como conseqüência de usar uma MotifWidgetFactory.

## Aplicabilidade

Use o padrão Abstract Factory quando:

• um sistema deve ser independente de como seus produtos são criados,
compostos ou representados;

• um sistema deve ser configurado como um produto de uma família de
múltiplos produtos;

• uma família de objetos-produto for projetada para ser usada em conjunto,
e você necessita garantir esta restrição;

• você quer fornecer uma biblioteca de classes de produtos e quer revelar
somente suas interfaces, não suas implementações.


## Estrutura

<figure>
<img src="/assets/structure.png">

</figure>


## Participantes
<strong>• AbstractFactory</strong> (WidgetFactory)
– declara uma interface para operações que criam objetos-produto abstratos.

<strong>• Concrete Factory</strong> (MotifWidgetFactory, PMWidgetFactory)
– implementa as operações que criam objetos-produto concretos.

<strong>• AbstractProduct</strong> (Window, ScrollBar)
– declara uma interface para um tipo de objeto-produto

<strong>• ConcreteProduct</strong> (MotifWindow, MotifScrollBar)
– define um objeto-produto a ser criado pela correspondente fábrica concreta.
– implementa a interface de Abstract Product.

<strong>• Client</strong> 
– Usa as interfaces declaradas pelas classes AbstractFactory e AbstractProduct.


## Colaborações

• Normalmente uma única instância de uma classe ConcreteFactory é criada
em tempo de execução. Essa fábrica concreta cria objetos-produto que têm
uma implementação particular. Para criar diferentes objetos-produto, os
clientes deveriam usar uma fábrica concreta diferente.

• AbstractFactory adia a criação dos objetos-produto para as suas subclasses ConcreteFactory.


## Consequências

O padrão Abstract Factory tem os seguintes benefícios e desvantagens:

1. Ele isola as classes concretas. O padrão Abstract Factory ajuda a controlar as
classes de objetos criadas por uma aplicação. Uma vez que a fábrica encapsula
a responsabilidade e o processo de criar objetos-produto, isola os clientes das
classes de implementação. Os clientes manipulam as instâncias através das
suas interfaces abstratas. Nomes de classes-produto ficam isolados na
implementação da fábrica concreta; eles não aparecem no código do cliente.
<br>
2. Ele torna fácil a troca de famílias de produtos. A classe de uma fábrica concreta
aparece apenas uma vez numa aplicação – isto é, quando é instanciada. Isso
torna fácil mudar a fábrica concreta que uma aplicação usa. Ela pode usar
diferentes configurações de produtos simplesmente trocando a fábrica concreta. Uma vez que a fábrica abstrata cria uma família completa de produtos,
toda família de produtos muda de uma só vez. No nosso exemplo de
interface de usuário, podemos mudar de widgets do Motif para widgets do
Presentation Manager simplesmente trocando os correspondentes objetosfábrica e recriando a interface.
<br>
3. Ela promove a harmonia entre produtos. Quando objetos-produto numa família
são projetados para trabalharem juntos, é importante que uma aplicação use
objetos de somente uma família de cada vez. AbstractFactory torna fácil
assegurar isso.
<br>
4. É difícil de suportar novos tipos de produtos. Estender fábricas abstratas para
produzir novos tipos de Produtos não é fácil. Isso se deve ao fato de que a
interface de AbstractFactory fixa o conjunto de produtos que podem ser
criados. Suportar novos tipos de produto exige estender a interface da
fábrica, o que envolve mudar a classe AbstractFactory e todas as suas
subclasses. Discutimos uma solução para este problema na seção de
Implementação.
<br>


## Implementação

• A classe AbstractFactory é aquela que determina o tipo real do objeto concreto e o cria, mas retorna uma referência abstrata ao objeto concreto recém-criado.

• Isso determina o comportamento do cliente que pede à fábrica para criar um objeto de um determinado tipo abstrato e retornar o ponteiro abstrato para ele, impedindo que o cliente saiba algo sobre a criação real do objeto.

• O fato da fábrica retornar um ponteiro abstrato para o objeto criado significa que o cliente não tem conhecimento do tipo do objeto. Isso implica que não há necessidade de incluir nenhuma declaração de classe relacionada ao tipo concreto, o cliente lida o tempo todo com o tipo abstrato.

• Os objetos do tipo concreto, criados pela fábrica, são acessados pelo cliente apenas através da interface abstrata. A segunda implicação dessa maneira de criar objetos é que, ao adicionar novos tipos concretos, basta modificar o código do cliente e fazer com que ele use uma fábrica diferente, o que é muito mais fácil do que instanciar um novo tipo, o que requer alteração o código sempre que um novo objeto é criado.

 

A implementação clássica para o padrão Abstract Factory é a seguinte:

<figure>
<img src="/assets/code implement.png">

</figure>


## Exemplo de código

Vamos levar o conceito de kit de ferramentas de interface do usuário para nosso exemplo de código Java. Vamos criar um aplicativo cliente que precisa criar uma janela.

 
1. Primeiro, precisamos criar nossa interface Window. A janela é o nosso AbstractProduct.

<figure>
<img src="/assets/00.png">

</figure>


2. Vamos criar duas implementações do Window, como nossos ConcreteProducts. Um para Microsoft Windows:

<figure>
<img src="/assets/01.png">

</figure>


3. E um para Mac OSX:

<figure>
<img src="/assets/02.png">

</figure>




4. Agora precisamos fornecer nossas fábricas. Primeiro vamos definir nosso AbstractFactory. Para este exemplo, digamos que eles apenas criem o Windows:

<figure>
<img src="/assets/03.png">

</figure>



5. Em seguida, precisamos fornecer implementações ConcreteFactory dessas fábricas para nossos dois sistemas operacionais. Primeiro para MS Windows:

<figure>
<img src="/assets/04.png">

</figure>


6. E para MacOSX:

<figure>
<img src="/assets/05.png">

</figure>


7. Por fim, precisamos de um cliente para aproveitar todas essas funcionalidades.

<figure>
<img src="/assets/06.png">

</figure>


8. Precisamos de alguma forma para especificar qual tipo de AbstractWidgetFactory para o nosso GUIBuilder. Isso geralmente é feito com uma instrução switch semelhante ao código abaixo:

<figure>
<img src="/assets/07.png">

</figure>


## Usos conhecidos

InterViews usa o sufixo “Kit” [Lin92] para denotar classes AbstractFactory. Ela define
fábricas abstratas WidgetKit e DialogKit para geração de objetos específicos da
interface de usuário para interação. InterViews também inclui LayoutKit, que gera
diferentes objetos por composição dependendo do layout desejado. Por exemplo, um
layout que é conceitualmente horizontal pode exigir diferentes objetos compostos,
dependendo da orientação do documento (retrato ou paisagem).
ET++ [WGM88] usa o padrão Abstract Factory para obter portabilidade entre
diferentes sistemas de janelas (X Windows e SunView, por exemplo). A classe
abstrata base WindowSystem define a interface para criar objetos que representam
recursos do sistema de janelas (MakeWindow, MakeFont, MakeColor, por exemplo).
As subclasses concretas implementam as interfaces para um sistema de janelas
específico. Em tempo de execução, ET++ cria uma instância de uma subclasse
concreta WindowSystem que cria objetos concretos para os recursos do sistema.

## Padrão relacionados
As classes AbstractFactory são freqüentemente implementadas com métodos-fábrica
Factory Method, mas elas também podem ser implementadasusando Prototype.
Uma fábrica concreta é freqüentemente um singleton.

## Referências

<strong>ERICK GAMMA</strong>, Padrões de Projetos: Soluções Reutilizáveis de Software Orientados a Objetos,  Bookman; 1ª edição (1 janeiro 2000)

<strong>ABSTRACT FACTORY PATTERN - STARTERTUTORIALS</strong>, https://www.startertutorials.com/patterns/abstract-factory-pattern.html

<strong>REFACTORING GURU:</strong> https://refactoring.guru/pt-br/design-patterns/abstract-factory

