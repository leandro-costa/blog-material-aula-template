---
icon: edit
date: 2023-04-05 20:20:00.00 -3
tag:
  - linguagem
  - programação
  - c
category:
  - Aula
order: 4
---

# Esqueleto de um programa em linguagem c

[^BACKES] [^SOFFNER]

Todo programa escrito em linguagem C que vier a ser desenvolvido deve possuir o esqueleto mostrado no código-fonte abaixo.

```c
#include <stdio.h>
#include <stdlib.h>
int main(){
    printf("Hello World \n");
    system("pause");
    return 0;
}
```
À primeira vista, esse parece ser um programa fútil, já que sua única finalidade é mostrar na tela uma mensagem dizendo *Hello World*, fazer uma pausa e terminar o programa. Porém, ele permite aprender alguns dos conceitos básicos da linguagem C

```c
#include <stdio.h>//declarações globais
#include <stdlib.h>//Bibliotecas utilizadas pelo programa
int main(){//inicio do programa
    printf("Hello World \n");//escreve uma mensagem na tela de saída
    system("pause");//faz uma pausa antes de terminar o programa
    return 0;//retorna o valor 0 para o SO informando que finalizou sem erros
}//fim do programa
```

## Entendendo o código 


Temos, no início do programa, a região onde são feitas as suas declarações globais,  ou  seja,  aquelas  que  são  válidas  para  todo  o  programa.  No  exemplo,  o comando `#include <nome_da_biblioteca>` é utilizado para declarar as bibliotecas que serão utilizadas. 


::: tip Biblioteca
Uma biblioteca é um conjunto de funções (pedaços de código) já implementados e que podem ser utilizados pelo programador. 
:::


No exemplo anterior, duas bibliotecas foram adicionadas ao programa: `stdio.h` (que contém as funções de leitura do teclado e escrita em tela) e `stdlib.h` (que contem funções de conversões de tipos e alocação de memória). 

Todo o programa em linguagem C deve conter a função `main()`. Essa função é responsável pelo início da execução do programa, e é dentro dela que colocamos os comandos que queremos que o programa execute. 

::: tip Chaves
As chaves definem o início ("{") e o fim ("}") de um bloco de comandos/instruções. 
:::

No exemplo, as chaves definem o início e o fim do programa.

A função `main()` foi definida como uma função `int` (ou seja, retorna um valor do tipo inteiro) e, por isso, precisa devolver um valor inteiro. Temos então a necessidade do comando `return 0` apenas para informar que o programa chegou ao seu final e que está tudo OK.

A função `printf()` está definida na biblioteca `stdio.h`. Ela serve para imprimir uma mensagem de texto na tela do terminal. 

O texto a ser escrito deve estar entre aspas duplas, e, dentro dele, podemos também colocar caracteres especiais, como o "\n", que indica que é para mudar de linha antes de continuar a escrever na tela.

O comando `system("pause")` serve para interromper a execução do programa (fazer uma pausa) para que se possa analisar a tela de saída, após o término da execução do programa. Ela está definida dentro da biblioteca `stdlib.h`. 

Fim de instruções quase sempre termina com ponto e vírgula(";"). 

Os parênteses definem o início ("(") e o fim (")") da lista de argumentos de uma função. Um argumento é a informação que será passada para a função utilizar. No exemplo, podemos ver que os comandos `main`, `printf` e `system` são funções. 

## Indentação do código

Outra coisa importante que devemos ter em mente quando escrevemos um programa é a indentação do código. Trata-se de uma convenção de escrita de códigos-fonte que visa a modificar a estética do programa para auxiliar a sua leitura e interpretação.

::: tip Identação
A indentação é o espaçamento (ou tabulação) colocado antes de começar a escrever o código na linha. Ela tem como objetivo indicar a hierarquia dos elementos. 
:::

No nosso exemplo, os comandos `printf()`, `system()` e `return` possuem a mesma hierarquia (portanto, o mesmo espaçamento) e estão todos contidos dentro do comando `main()` (daí o porquê do espaçamento). 

O ideal é sempre criar um novo nível de indentação para um novo bloco de comandos.

A indentação é importante, pois o nosso exemplo anterior poderia ser escrito em apenas três linhas, sem afetar o seu desempenho, mas com alto grau de dificuldade de leitura para o programador 
```c
#include <stdio.h> 
#include <stdlib.h> 
int main(){printf("Hello World \n"); system("pause"); return 0;}
```


## Entrada e saída de dados

### printf

A função `printf()` é uma das funções de saída/escrita de dados da linguagem C. Seu nome vem da expressão em inglês print formatted, ou seja, escrita formatada. Basicamente, a função `printf()` escreve na saída de vídeo (tela) um conjunto de valores, caracteres e/ou sequência de caracteres de acordo com o formato especificado.

A forma geral da função `printf()` é:

```c
printf("tipos de saída", lista de variáveis)
```

A função `printf()` recebe dois parâmetros de entrada:

- *"tipos de saída"*: conjunto de caracteres que especifica o formato dos dados a serem escritos e/ou o texto a ser escrito.
- *lista de variáveis*: conjunto de nomes de variáveis, separados por vírgula, que serão escritos.

#### Escrevendo valores formatados

Quando queremos escrever dados formatados na tela usamos a forma geral da função, a qual possui os tipos de saída. Eles especificam o formato de saída dos dados que serão escritos pela função `printf()`. Cada tipo de saída é precedido por um sinal de "\%", e um tipo de saída deve ser especificado para cada variável a ser escrita. 

Assim, se quiséssemos escrever uma única expressão com o comando `printf()`, faríamos 

```c
printf("%tipo", expressão);
printf("%tipo1 %tipo2", expressão1, expressão2);
```

Note que os formatos e as expressões a serem escritas com aquele formato devem ser especificados na mesma ordem. Além disso, as variáveis e/ou expressão devem ser separadas por vírgulas.

| Tipos    | Saída para o printf                              |
| -------- | ------------------------------------------------ |
| %c       | escrita de um caractere (char)                   |
| %d ou %i | escrita de números inteiros (int ou char)        |
| %u       | escrita de números inteiros sem sinal (unsigned) |
| %f       | escrita de número reais (float ou double)        |
| %s       | escrita de vários caracteres                     |
| %p       | escrita de um endereço de memória                |
| %e ou %E | escrita em notação científica                    |

### Scanf

A função `scanf()` é uma das funções de entrada/leitura de dados da linguagem C. Seu nome vem da expressão em inglês scan formatted, ou seja, leitura formatada. Basicamente, a função `scanf()` lê do teclado um conjunto de valores, caracteres e/ou sequência de caracteres, de acordo com o formato especificado. A forma geral da função `scanf()` é:

```c
scanf("tipos de entrada", lista de variáveis)
```

A função `scanf()` recebe dois parâmetros de entrada:
- *"tipos de entrada"*: conjunto de caracteres que especifica o formato dos dados a serem lidos.
- *lista de variáveis*: conjunto de nomes de variáveis que serão lidos e separados por vírgula, em que cada nome de variável é precedido pelo operador \&.

Os *tipo de entrada* especificam o formato de entrada dos dados que serão lidos pela função `scanf()`. Cada tipo de entrada é precedido por um sinal de \%, e um tipo de entrada deve ser especificado para cada variável a ser lida. Assim, se quiséssemos ler uma única variável com o comando `scanf()`, faríamos: 

```c
scanf("%tipo", &variavel)
```

Se fossem duas as variáveis a serem lidas, faríamos:

```c
scanf("%tipo1 %tipo2", &variavel1, &variavel2)
```

e assim por diante. Note que os formatos e as variáveis que armazenarão o dado com aquele formato  devem  ser  especificados  na  mesma  ordem. Além disso, as variáveis devem ser separadas por vírgulas.

:::warning 
Na linguagem C, é necessário colocar o símbolo \& antes do nome de cada variável a ser lida pelo comando `scanf()`.
:::

Todas as variáveis que receberão valores do teclado por meio de `scanf()` deverão ser passadas pelos seus endereços. Isso se faz colocando o operador de endereço "&" antes do nome da variável.

A função `scanf()` pode ser usada para ler praticamente qualquer tipo de dado. No entanto, ela é usada com mais frequência para a leitura de números inteiros e/ou de ponto flutuante (números reais). A Tabela abaixo mostra alguns dos tipos de saída suportados pela linguagem.

| Tipo     | Leitura de dado                           |
| -------- | ----------------------------------------- |
| %c       | leitura de um caractere (char)            |
| %d ou %i | leitura de números inteiros (int ou char) |
| %f       | leitura de número reais (float ou double) |
| %s       | leitura de vários caracteres              |
[Tipos de leituras de dados]

```c
#include <stdio.h>
#include <stdlib.h>
int main(){  
  int x,z;
  float y
  //Leitura de um valor inteiro
  scanf("%d",&x);
  //Leitura de um valor real
  scanf("%f",&y);
  //Leitura de um valor inteiro e outro real
  scanf("%d%f",&x,&y);
  //Leitura de dois valores inteiros
  scanf("%d%d",&x,&z);
  //Leitura de dois valores inteiros com espaco
  scanf("%d %d",&x,&z);  
  system("pause");
  return 0;
}
```

Nesse exemplo, os comandos 
```c
scanf("%d%d",&x,&z); 
```
e 
```c
scanf("%d %d",&x,&z);
```
são equivalentes. Isso ocorre porque o comando `scanf()` ignora os espaços em branco entre os tipos de entrada. Além disso, quando o comando `scanf()` é usado para ler dois ou mais valores, podemos optar por duas formas de digitar os dados no teclado:

- Digitar um valor e, em seguida, pressionar a tecla *ENTER*. Fazer isso para cada valor a ser digitado.
- Digitar todos os valores separados por espaço e, por último, pressionar a tecla *ENTER*.

O comando `scanf()` ignora apenas os espaços em branco entre os tipos de entrada. Qualquer outro caractere inserido entre os tipos de dados deverá ser digitado pelo usuário, mas será descartado pelo programa.

```c
#include <stdio.h>
#include <stdlib.h>
int main(){  
  int dia, mes, ano;
  //Leitura de tres valores inteiros
  //com barras entre eles
  scanf("%d/%d/%d",&dia,&mes,&ano);
  system("pause");  
  return 0;
}
```

No exemplo acima, o comando `scanf()` é usado para a entrada de três valores inteiros separados por uma barra ("/") cada(dados  formatados como uma data: *dia/mês/ano*). Quando o usuário for digitar os três valores, será obrigado a digitar os três valores separados por barra (as barras serão descartadas e não interferem nos dados). 

## Exercícios

[Exercício](exercicios/01_estrutura_c.md)

## Referências

@include(../bib/bib.md)
