Padrões para serem usados em jogo de tabuleiro

Pensando na utilização em um jogo de xadrez, podemo utilizar os seguintes padrões:

# Padrões criacionais
- **Builder**: Para criação das peças e cores de cada peça.
- **Prototype**: Para criar copias de peões já existentes feitos pelo builder.

Pensando na preparação das partidas (tabuleiro, peças, jogadores etc) podemos usar o seguinte padrão:

# Padrão estrutural 
- **Facade**: Para fornecer a conexão entre o cliente e a solicitação feita para o inicio de um jogo especifico (por exemplo, o cliente solicita um jogo que
  necessita de uma determinada peça, o facade envia a requisição do cliente para o builder que irá fazer a criação da peça)

Seguindo as regras do jogo selva, podemos também utilizar do padrão estrutural 
- **Decorator**: Nesse padrão podemos adicionar novos comportamentos a algumas peças que tem capacidade adicional no jogo.
