---
icon: edit
date: 2023-04-23 22:00:00.00 -3
tag:
  - entrada_saida
  - condicional
category:
  - exercicio
star: true
---
# Lista de Exercícios

[^BACKES]

## Entrada e Saída

1. Desenvolver a lógica para um programa que efetue o cálculo da área de uma circunferência, apresentando a medida da área calculada.

    Algoritmo:

    Para efetuar o cálculo da área de uma circunferência é necessário conhecer a fórmula que executa este cálculo, sendo esta: $A = \pi R^2$, em que A é a variável que conterá o resultado do cálculo da área, $\pi$ é o valor de pi (3.14159, sendo uma constante na fórmula) e R o valor do raio. Sendo assim, estabelece-se:

    1. Ler um valor para o raio, na variável R;
    2. Estabelecer que $\pi$ possui o valor 3.14159;
    3. Efetuar o cálculo da área, elevando ao quadrado o valor de R e multiplicando por $\pi$;
    4. Apresentar o valor da variável A.

    A fórmula para o cálculo da área passará a ser escrita como: $A = 3.14159 * R^2$.
2. Construir um programa que efetue o cálculo do salário líquido de um professor. Para fazer este programa, você deverá possuir alguns dados, tais como: valor da hora-aula, número de horas trabalhadas no mês e o percentual de desconto do INSS. Em primeiro lugar, deve-se estabelecer qual será o seu salário bruto para efetuar o desconto e ter o valor do salário líquido.

    Algoritmo:

    1. Ler a variável HT (horas trabalhadas no mês);
    2. Ler a variável VH (valor hora-aula);
    3. Ler a variável PD (percentual de desconto);
    4. Calcular o salário bruto (SB), sendo este a multiplicação das variáveis HT e VH;
    5. Calcular o total de desconto (TD), com base no valor de PD dividido por 100;
    6. Calcular o salário líquido (SL), deduzindo o desconto do salário bruto;
    7. Apresentar os valores dos salários bruto e líquido: SB e SL.
3. Ler uma temperatura em graus Celsius e apresentá-la convertida em graus Fahrenheit. A fórmula de conversão é 
    $$F = \frac{(9 \times C + 160)}{5} $$
    sendo F a temperatura em Fahrenheit e C a temperatura em Celsius.
4. Ler uma temperatura em graus Fahrenheit e apresentá-la convertida em graus Celsius. A fórmula de conversão é 
    $$C = (F - 32) \times \frac{5}{9}$$
    sendo F a temperatura em Fahrenheit e C a temperatura em Celsius.
5. Calcular e apresentar o valor do volume de uma lata de óleo, utilizando a fórmula: 
    $$Volume = \pi \times Raio^2 \times Altura$$
6. Efetuar o cálculo da quantidade de litros de combustível gasta em uma viagem, utilizando um automóvel que faz 12 Km por litro. Para obter o cálculo, o usuário deve fornecer o tempo gasto (`TEMPO`) e a velocidade média (`VELOCIDADE`) durante a viagem. Desta forma, será possível obter a distância percorrida com a fórmula 
    $$DISTANCIA = TEMPO \times VELOCIDADE$$
    Possuindo o valor da distância, basta calcular a quantidade de litros de combustível utilizada na viagem com a fórmula 
    $$LITROS\_USADOS = \frac{DISTANCIA}{12}$$
    Ao final, o programa deve apresentar os valores da velocidade média (`VELOCIDADE`), tempo gasto na viagem (`TEMPO`), a distancia percorrida (`DISTANCIA`) e a quantidade de litros (`LITROS_USADOS`) utilizada na viagem. 
    Efetuar o cálculo e a apresentação do valor de uma prestação em atraso, utilizando a fórmula
    $$PRESTACAO = VALOR + (VALOR \times \frac{TAXA}{100}) \times TEMPO)$$.
7. Ler dois valores (inteiros, reais ou caracteres) para as variáveis `A` e `B`, e efetuar a troca dos valores de forma que a variável `A` passe a possuir o valor da variável `B` e a variável `B` passe a possuir o valor da variável `A`. Apresentar os valores trocados.
8. Ler quatro números inteiros e apresentar o resultado da adição e multiplicação, baseando-se na utilização do conceito da propriedade distributiva. Ou seja, se forem lidas as variáveis A, B, C, e D, devem ser somadas e multiplicadas A com B, A com C e A com D. Depois B com C, B com D e por fim C com D. Perceba que será necessário efetuar seis operações de adição e seis operações de multiplicação e apresentar doze resultados de saída.
9. Elaborar um programa que calcule e apresente o volume de uma caixa retangular, por meio da fórmula:
$$VOLUME = COMPRIMENTO \times LARGURA \times ALTURA$$.
1. Ler dois inteiros (variáveis A e B) e imprimir o resultado do quadrado da diferença do primeiro valor pelo segundo.
2. Elaborar um programa que efetue a apresentação do valor da conversão em real de um valor lido em dólar. O programa deve solicitar o valor da cotação do dólar e também a quantidade de dólares disponível com o usuário, para que seja apresentado o valor em moeda brasileira.
3. Elaborar um programa que efetue a apresentação do valor da conversão em dólar de um valor lido em real. O programa deve solicitar o valor da cotação do dólar e também a quantidade de reais disponível com o usuário, para que seja apresentado o valor em moeda americana.
4. Elaborar um programa que efetue a leitura de três valores (A, B e C) e apresente como resultado final à soma dos quadrados dos três valores lidos.
5. Elaborar um programa que efetue a leitura de três valores (A,B e C) e apresente como resultado final o quadrado da soma dos três valores lidos.
6. Elaborar um programa de computador que efetue a leitura de quatro valores inteiros (variáveis A, B, C e D). Ao final o programa deve apresentar o resultado do produto (variável P) do primeiro com o terceiro valor, e o resultado do produto (variável P) do primeiro com o terceiro valor, e o resultado da soma (variável S) do segundo com o quarto valor.
7. Ler o valor correspondente ao salário mensal (variável SM) de um trabalhador e também o valor do percentual de reajuste (variável PR) a ser atribuído. Apresentar o valor do novo salário (variável NS).
8. Em uma eleição sindical concorreram ao cargo de presidente três candidatos (A, B e C). Durante a apuração dos votos foram computados votos nulos e votos em branco, além dos votos válidos para cada candidato. Deve ser criado um programa de computador que efetue a leitura da quantidade de votos válidos para cada candidato, além de efetuar também a leitura da quantidade de votos nulos e votos em branco. Ao final o programa deve apresentar 
   1. o número total de eleitores, considerando votos válidos, nulos e em branco; 
   2. o percentual correspondente de votos válidos em relação à quantidade de eleitores; 
   3. o percentual correspondente de votos válidos do candidato A em relação à quantidade de eleitores; 
   4. o percentual correspondente de votos válidos do candidato B em relação à quantidade de eleitores; 
   5. o percentual correspondente de votos válidos do candidato C em relação à quantidade de eleitores; 
   6. o percentual correspondente de votos nulos em relação à quantidade de eleitores; 
   7. e por último o percentual correspondente de votos em branco em relação à quantidade de eleitores.
9. Elabore um algoritmo que leia um número inteiro e apresente o antecessor, o número e o sucessor
10. Escreva um algoritmo que calcule a área de um triângulo usando a seguinte formula:
    $$Area = \frac{base \times altura}{2}$$
11. Construa um algoritmo que leia o preço de um produto, o percentual de desconto e calcule o valor a pagar e o valor do desconto
12. Elabore um algoritmo que leia a quantidade de livros que uma locadora de livros possui e o valor do aluguel por livro. apresente as seguintes informações: 
    1.  faturamento mensal se todos os livros forem locados; 
    2.  faturamento anual se 20\% dos livros não forem locados todo mês.

## Condicionais

1. Ler três valores para os lados de um triângulo, considerando lados como: A, B e C. Verificar se os lados fornecidos formam realmente um triângulo. Se for esta condição verdadeira, deve ser indicado qual tipo de triângulo foi formado: isósceles, escaleno ou equilátero.

    Algoritmo
    Para se estabelecer esse algoritmo é necessário em primeiro lugar saber o que realmente é um triângulo. 
    Triângulo é uma forma geométrica (polígono) composta por três lados, em que cada lado é menor que a soma dos outros dois lados. Perceba que esta é uma regra (uma condição) e deve ser considerada. É um triângulo quando $A < (B + C)$, quando $B < (A + C)$ e quando $C < (A + B)$. 
    
    Tendo certeza de que os valores informados para os três lados formam um triângulo, são então analisados os valores para se estabelecer qual tipo de triângulo é formado: isósceles, escaleno ou equilátero. Um triângulo é isósceles quando possui dois lados iguais e um diferente, sendo $A=B$ ou $A=C$ ou $B=C$; é escaleno quando possui todos os lados diferentes, sendo $A<>B$ e $B<>C$ e $C<>A$ e é equilátero quando possui todos os lados iguais, sendo $A=B$ e $B=C$.
    1. Ler três valores para os lados de um triângulo: A, B e C;
    1. Verificar se cada lado é menor que a soma dos outros dois lados;
        1. Se sim, saber se $A=B$ e se $B=C$ sendo verdade, o triângulo é equilátero;
        1. Se não, verificar se $A=B$ ou se $A=C$ ou se $B=C$; sendo verdade, o triângulo é isósceles, caso contrário o triângulo é escaleno.
    1. Caso os lados fornecidos não caracterizem um triângulo, avisa a ocorrência. 
2. Desenvolver um programa que efetue a leitura de um valor numérico inteiro e apresente-o caso este valor seja divisível por 4 e 5. Não sendo divisível por 4 e 5 o programa deverá apresentar a mensagem "Não é divisível por 4 e 5".
    Algoritmo
    1. Ler um número inteiro qualquer, no caso o número N;
    2. Calcular o resto da divisão de N por 4, usar a variável R_4;
    3. Calcular o resto da divisão de N por 5, usar a variável R_5;
    4. Verificar se ambas as variáveis possuem o valor ZERO, se sim apresentar a variável N, se não apresentar a mensagem "Não é divisível por 4 e 5"
1. Ler dois valores numéricos inteiros e apresentar o resultado da diferença do maior pelo menor valor.
1. Efetuar a leitura de um valor inteiro positivo ou negativo e apresentar o número lido como sendo um valor positivo, ou seja, o programa deverá apresentar o módulo de um número fornecido. Lembre-se de verificar se o número fornecido é menor que zero; sendo, multiplique-o por $-1$.
1. Ler quatro valores referentes a quatro notas escolares de um aluno e imprimir uma mensagem dizendo que o aluno foi aprovado, se o valor da média escolar for maior ou igual a 5. Se o aluno não foi aprovado, indicar uma mensagem informando esta condição. Apresentar junto das mensagens o valor da média do aluno para qualquer condição.
1. Ler quatro valores referentes a quatro notas escolares de um aluno e imprimir uma mensagem dizendo que o aluno foi aprovado, se o valor da média escolar for maior ou igual a 7. Se o valor da média for menor que 7, solicitar a nota de prova final, somar com o valor da média e obter nova média. Se a nova média for maior ou igual a 5, apresentar uma mensagem dizendo que o aluno foi aprovado em prova final. Se o aluno não foi aprovado, indicar uma mensagem informando esta condição. Apresentar com as mensagens o valor da média do aluno, para qualquer condição.
1. Efetuar a leitura de três valores (variáveis A, B e C) e efetuar o cálculo da equação completa de segundo grau, apresentando as duas raízes, se para os valores informados for possível efetuar o referido cálculo. Lembre-se de que a variável A deve ser diferente de zero. Dada a equação $f(x) = ax^2 + bx + c$ as raízes são obtidas por $x=\frac{-b \pm \sqrt{b^2-4ac}}{2a}$.
1. Efetuar a leitura de três valores (variáveis A, B e C) e apresentá-los dispostos em ordem crescente.
1. Efetuar a leitura de quatro números inteiros e apresentar os números que são divisíveis por 2 e 3.
1. Efetuar a leitura de cinco números inteiros e identificar o maior e o menor valores.
1. Elaborar um programa que efetue a leitura de um número inteiro e apresentar uma mensagem informando se o número é par ou ímpar. 
1. Elaborar um programa que efetue a leitura de um valor que esteja entre a faixa de 1 a 9. Após a leitura do valor fornecido pelo usuário, o programa deverá indicar uma de duas mensagens: "O valor está na faixa permitida", caso o usuário forneça o valor nesta faixa, ou a mensagem "O valor está fora da faixa permitida", caso o usuário forneça valores menores que 1 ou maiores que 9.
1. Elaborar um programa que efetue a leitura de um determinado valor inteiro, e efetue a sua apresentação, caso o valor não seja maior que três.
1. Formule um algoritmo que leia a matrícula e nome de um vendedor, seu salário fixo e o total de vendas e calcule a comissão do vendedor. Se o total de vendas é inferior a R\$ 1500,00 o percentual de comissão é 2\% e se for maior o percentual é de 4\%. Apresente o nome do vendedor, matrícula, salário ixo e salário total.
1. Escreva um algoritmo que leia um número e informe se ele é divisível por 3 e por 7.
1. Formule um algoritmo que leia cinco números e conte quantos deles são negativos.
1. De acordo com uma tabela médica, o peso ideal está relacionado com a altura e o sexo. Elabore um algoritmo que receba altura e sexo de uma pessoa e calcule e imprima o seu peso ideal, sabendo que:
    - Homens: $(72,7 \times h) – 58$
    - Mulheres: $(62,1 \times h) – 44,7$
1. Elabore um algoritmo que leia o percurso em quilômetros, o tipo de moto e informe o consumo estimado de combustível, sabendo que uma moto do tipo `A` faz 26 km com um litro de gasolina, uma moto do tipo `B` faz 20 km e o tipo `C` faz 7 km.
1. Uma instituição financeira concederá crédito a uma taxa de juros de 3\% aos seus clientes de acordo com o saldo médio do período. Elabore um algoritmo que calcule o valor que pode ser concedido ao cliente e imprima-o. Os clientes com saldo médio inferior a R\$ 500,00 não têm direito a crédito. Já os clientes com saldo entre R\$ 501,00 e R\$ 1000,00 podem obter créditos de 35\% em relação ao saldo médio. Clientes com saldo entre R\$ 1001,00 a R\$ 3000,00 podem obter créditos de 50\% em relação ao saldo médio. E para aqueles clientes com saldo superior a R\$ 3001,00 pode ser concedido crédito de 75\% do valor do saldo.

## Repetição

1. Faça um programa que leia um número inteiro positivo N e imprima todos os  números naturais de 0 até N em ordem crescente.
1. Faça um programa que leia um número inteiro positivo N e imprima todos os  números naturais de 0 até N em ordem decrescente.
1. Faça um programa que leia um número inteiro N e depois imprima os N primeiros números naturais ímpares.
1. Faça um programa que determine e mostre os cinco primeiros múltiplos de 3  considerando números maiores que 0.
1. Faça um programa que calcule e mostre a soma dos 50 primeiros números pares.
1. Faça um programa que mostre uma contagem regressiva na tela, iniciando em 10  e terminando em 0. Mostre uma mensagem "FIM!" após a contagem.
1. Elabore um programa que peça ao usuário para digitar 10 valores. Some esses  valores e apresente o resultado na tela.
1. Faça um programa que leia 10 inteiros e imprima sua média.
1. Escreva um programa que leia 10 números e escreva o menor valor lido e o maior  valor lido.
1. Faça um programa que leia 10 inteiros positivos, ignorando não positivos, e imprima sua média.
1. Faça um algoritmo que leia um número positivo e imprima seus divisores. Exemplo: os divisores do número 66 são: 1, 2, 3, 6, 11, 22, 33 e 66.
1. Escreva um programa que leia um número inteiro e calcule a soma de todos os  divisores desse número, com exceção dele próprio. Exemplo: a soma dos divisores  do número 66 é 1 + 2 + 3 + 6 + 11 + 22 + 33 = 78.
1. Faça um programa que exiba a soma de todos os números naturais abaixo de  1.000 que são múltiplos de 3 ou 5.
1. Escreva um programa que leia um número inteiro, maior ou igual a zero, do usuário. Imprima o enésimo termo da sequência de Fibonacci. Essa sequência começa  no termo de ordem zero, e, a partir do segundo termo, seu valor é dado pela soma  dos dois termos anteriores. Alguns termos dessa sequência são: 0, 1, 1, 2, 3, 5, 8,  13, 21, 34.
1. Elabore um programa que faça a leitura de vários números inteiros até que se digite um número negativo. O programa tem de retornar o maior e o menor número  lido.
1. Em matemática, a série harmônica é a série infinita definida como:
    $$\sum _{k=1}^{\infty }{\frac {1}{k}}=1+{\frac {1}{2}}+{\frac {1}{3}}+{\frac {1}{4}}+\cdots$$
    O n-ésimo($H_{n}$) número harmônico é designado por:
    $${H_{n}=\sum _{k=1}^{n}{\frac {1}{k}}}=1+{\frac {1}{2}}+{\frac {1}{3}}+{\frac {1}{4}}+\cdots+{\frac {1}{n}}$$
    Apresente um programa que calcule o valor de qualquer $H_{n}$.
1. Escreva um programa que leia um número inteiro positivo N e em seguida imprima N linhas do chamado triângulo de Floyd:
    ```console
    1
    2 3
    4 5 6
    7 8 9 10
    11 12 13 14 15
    16 17 18 19 20 21
    ```
1. Faça um programa que receba um número inteiro maior do que 1 e verifique se o  número fornecido é primo ou não.
1. Faça um programa que calcule e escreva o valor de S:
    $$S={\frac {1}{1}}+{\frac {3}{2}}+{\frac {5}{3}}+{\frac {7}{4}}+{\frac {9}{5}}+\cdots +{\frac {1}{55}}$$
1. Na matemática, o fatorial de um número natural n, representado por n!, é o produto de todos os inteiros positivos menores ou iguais a n. 
    A função fatorial é normalmente definida por:
    $$n!=\prod _{k=1}^{n}k=n\times (n-1)\times (n-2)\times ...\times 3\times 2\times 1,\qquad \forall n\in \mathbb {N}$$
    Faça um programa que leia um valor inteiro e positivo N, calcule o mostre o valor  E, conforme a fórmula a seguir:
    $$
    E={\frac {1}{1!}}
    +{\frac {1}{2!}}
    +{\frac {1}{3!}}
    +\cdots 
    +{\frac {1}{N!}}
    $$
1. Escreva um programa que leia certa quantidade de números, imprima o maior  deles e quantas vezes o maior número foi lido. A quantidade de números a serem lidos deve ser fornecida pelo usuário.

## Referências

<!-- @include: ../../bib/bib.md -->
