# Padrões para serem usados em jogo de tabuleiro

- Pensando na utilização no jogo SELVA, podemo utilizar os seguintes padrões:

## Padrões criacionais
- **Builder**: O builder permite a produção de diferentes tipos e representações de um objeto usando o mesmo codigo de construção, com isso, podemos utiliza-lo para a criação das peças do jogo e até tabuleiros, definindo as caracteristicas, como a estrutura, as cores e outros componentes que forem necessário.

- **Prototype**: O prototype é utilizado para copiar objetos já existentes, com isso, podemos utiliza-lo para criar copias de peças e até tabuleiros já existentes que foram feitas pelo builder.

## Padrão estrutural 
- **Facade**: O facade fornece uma interface simples para um framework ou até uma classe mais complexa, com ele vamos mostrar as funcionalidades que os clientes se importam, com essa ideia podemos fazer com que o cliente se comunique com o facade, que irá se comunicar com a classe necessaria para fazer o que o cliente quer, por exemplo, o cliente solicita um jogo que necessita de uma determinada peça, o facade irá se comunicar com o builder e enviar a requisição do cliente para que o builder possa fazer a criação da peça, ele também pode se comunicar com o prototype caso precise do clone de alguma peça ou tabuleiro. A ideia é que ele possa se comunicar com outras classes ou frameworks complexos de acordo com a necessidade do jogador (cliente).

- **Decorator**: O decorator é um padrão que permite adicionar novos comportamentos a um objeto, com ele podemos por exemplo adicionar um novo comportamento a uma peça especifica, a uma peça que possui o método andar(), com o decorator podemos criar uma nova camada nesse comportamento.
