---
icon: edit
date: 2023-07-06 20:10:00.00 -3
tag:
  - comportamentais
  - gof
category:
  - exercicio
excerpt: Apresentação dos Padrões Comportamentais do GOF
---

# Padrões Comportamentais

[^GAMMA]


Os padrões comportamentais se preocupam com algoritmos e a atribuição de responsabilidades entre objetos. Os padrões comportamentais não descrevem apenas padrões de objetos ou classes, mas também os padrões de comunicação entre eles. Esses padrões caracterizam fluxos de controle difíceis de seguir em tempo de execução. Eles afastam o foco do fluxo de controle para permitir que você se concentre somente na maneira como os objetos são interconectados.

Os padrões comportamentais de classe utilizam a herança para distribuir o comportamento entre classes. Este capítulo inclui dois padrões desse tipo. O Template Method (301) é o mais simples e o mais comum dos dois. Um método template é uma definição abstrata de um algoritmo. Ele define o algoritmo passo a passo. Cada passo invoca uma operação abstrata ou uma operação primitiva. Uma subclasse encarna um algoritmo através da definição das operações abstratas. O outro padrão comportamental de classe é Interpreter (231), o qual representa uma gramática como uma hierarquia de classes e implementa um interpretador como uma operação em instâncias destas classes.

Os padrões comportamentais de objetos utilizam a composição de objetos em vez da herança. Alguns descrevem como um grupo de objetos-pares cooperam para a execução de uma tarefa que nenhum objeto sozinho poderia executar por si mesmo. Um aspecto importante aqui é como os objetos-pares conhecem uns aos outros. Os pares poderiam manter referências explícitas uns para os outros, mas isso aumentaria o seu acoplamento. Levado ao extremo, cada objeto teria conhecimento de cada um dos demais. O padrão Mediator (257) evita essa situação pela introdução de um objeto mediador entre os objetos-pares. Um mediador fornece o referenciamento indireto necessário para um acoplamento fraco.

O padrão Chain of Responsibility (212) fornece um acoplamento ainda mais fraco. Ele permite enviar solicitações implicitamente para um objeto através de uma cadeia de objetos candidatos. Qualquer candidato pode satisfazer a solicitação dependendo de condições em tempo de execução. O número de candidatos é aberto e você pode selecionar quais candidatos participam da cadeia em tempo de execução.

O padrão Observer (274) define e mantém uma dependência entre objetos. O exemplo clássico do Observer está no Model/View/Controller da Smalltalk, onde todas as visões do modelo são notificadas sempre que o estado do modelo muda.

Outros padrões comportamentais de objetos se preocupam com o encapsulamento de comportamento em um objeto e com a delegação de solicitações para ele. O padrão [Strategy](../04_Strategy.md) encapsula um algoritmo num objeto. Strategy torna fácil especificar e mudar o algoritmo que um objeto usa. O padrão Command (222) encapsula uma solicitação num objeto, de maneira que possa ser passada como um parâmetro, armazenada numa lista histórica ou manipulada de outras formas. O padrão State (284) encapsula os estados de um objeto, de maneira que o objeto possa mudar o seu comportamento quando o seu objeto-estado mudar. Visitor (305) encapsula comportamento que, de outra forma, seria distribuído entre classes, Iterator (244) abstrai a maneira como objetos de um agregado são acessados e percorridos.

## Lista de padrões
|Padrão|Aluno|
|--|--|
|Chain of Responsibility ||
|Command ||
|Interpreter |@leandro-costa|
|Iterator |@leandro-costa|
|Mediator ||
|Memento |@FabricioLuisdeSousaSantos|
|Observer |@leandro-costa|
|State |@GabrielCoffee9|
|Strategy |@leandro-costa|
|Template Method ||
|Visitor ||

## Referências

<!-- @include: ../../bib/bib.md -->