---
icon: edit
date: 2023-04-20 20:10:00.00 -3
tag:
  - XX
  - gof
category:
  - aula
order: 10
excerpt: Apresentação do Padrão de Projeto XX
---

# XX (Modelo)

[^GAMMA]

## Intenção

...


## Também conhecido como

...

## Motivação

Cenário onde o padrão pode ajusadar
<figure>

```plantuml
@startuml

class BBBB
interface BBBB
abstract class CCCC

AAAA . BBBB
BBBB .. CCCC
AAAA .[norank]. CCCC

class AAAA1 extends AAAA
class BBBB1 implements BBBB
class CCCC1 extends CCCC


class Composition{
traverse()
repair()
}

interface Compositor{
compose()
}

Composition o- Compositor:compositor

note left of Composition::repair 
  compositor.compose()
end note

class SimpleCompositor{
    compose()
}
class TexCompositor{
    compose()
}
class ArrayCompositor{
    compose()
}
Compositor <|-- SimpleCompositor
Compositor <|-- TexCompositor
Compositor <|-- ArrayCompositor

hide empty attributes
hide empty methods

@enduml
```

<figcaption>Apresentação cenário.</figcaption>
</figure>

elementos dos cenário: 

- **aaa**:aaa
- **bbb**:bbb
- **ccc**:ccc

## Aplicabilidade

Use o padrão XXX quando:
## Estrutura

<figure>

```plantuml
@startuml
class Context{
contextinterface()
}

interface Strategy{
algorithminterface()
}

Context o- Strategy:strategy

class ConcreteStrategyA{
    algorithminterface()
}
class ConcreteStrategyB{
    algorithminterface()
}
class ConcreteStrategyC{
    algorithminterface()
}
Strategy <|-- ConcreteStrategyA
Strategy <|-- ConcreteStrategyB
Strategy <|-- ConcreteStrategyC

hide empty attributes
hide empty methods

@enduml
```

<figcaption>Estrutura do XX.</figcaption>
</figure>


## Participantes

- **XX** (aaa)
    - define ...
- **YY** (bbb)
    - implementa ...
- **ZZZ** (ccc)
    - é...

## Colaborações

- XX e Outro padrão interagem para...
- 
## Consequências

O padrão XX tem os seguintes benefícios e desvantagens:

## Implementação

Outro exemplo de aplicação do padrão...

```java
public class XX{
    //...
}
```


### Usos Conhecidos

Frameworks onde o padrão é aplicado

## Padrão relacionados
[Flyweight]: objetos Strategy geralmente são bons flyweights.


## Referências

<!-- @include: ../bib/bib.md -->
