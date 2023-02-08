# TPPE - TP3

Repositório para o trabalho prático 3 da disciplina Tópicos de Programação para Plataformas Emergentes - UnB 2022/2

## Simplicidade

### Descrição:
Dentro de qualquer software, a simplicidade nada mais é que um código que tem como propriedades a facilidade de leitura, compreensão e modificação, mesmo que por outras pessoas que não são os autores originais. A simplicidade é alcançada por meio da organização clara e coerente do código, bem como da utilização de convenções e boas práticas de programação. Ela auxilia na garantia da manutenibilidade, flexibilidade e escalabilidade de um software ao longo do tempo. 

A simplicidade é fortemente ligada ao ser humano, já que ela é tanto escrita por um programador quanto deverá ser facilmente entendida por outros. A simplicidade de código é diretamente relacionada aos maus cheiros, pois a remoção dos maus cheiros pode ajudar a tornar o código mais simples e fácil de entender.

### Relação com maus cheiros: 
Esta característica tem uma relação com os sinais de maus cheiros:

- Código duplicado: Ao ter fragmentos de código repetido em diferentes locais do projeto, a complexidade aumenta e a clareza é perdida.
- Método longo: Quanto maior o tamanho de um método, mais complexo ele se torna para ser compreendido.
- Classe grande: Quanto mais ampla a classe, mais difícil fica para compreender sua finalidade.

 
### Refatoração:
- Extrair Método: Essa operação permite diminuir o tamanho do método, tornando-o mais simples e fácil de compreender.
- Renomear Variável: Essa ação transforma o nome da variável para uma representação mais clara e de fácil compreensão.

## Boa documentação

### Descrição

A boa documentação de um software é fundamental para garantir sua eficiência, usabilidade e manutenção. A documentação deve ser clara, concisa e atualizada regularmente. Isso inclui informações sobre a instalação, configuração, uso, solução de problemas e atualizações do software. Uma boa documentação pode economizar tempo e esforço dos desenvolvedores, especialmente durante a fase de manutenção. Ao fornecer informações claras e precisas, a documentação permite que os desenvolvedores possam resolver problemas e implementar novas funcionalidades de maneira mais eficiente.

### Relação com Maus Cheiros

-   Comentários: quando o código não é autoexplicativo, é necessário comentar para que o código seja mais legível.
-   Mudanças divergentes: quando é necessario realizar mudanças em diversos métodos ao realizar uma mudança numa classe.

### Refatoração

Quando houver evolução no projeto de software, tanto o código quanto a documentação devem ser atualizadas, para que o software continue funcionando corretamente e a documentação continue sendo clara e concisa.


## Elegância

### Descrição

A elegância no código pode ter vários efeitos positivos no código. Abaixo estão algumas das vantagens de escrever código elegante:

- Leitura fácil: Código elegante é fácil de ler e entender, o que torna mais fácil para outros desenvolvedores trabalharem no projeto.
- Manutenibilidade: Código elegante é geralmente mais fácil de manter e corrigir, pois é mais claro e organizado.
- Reutilização: Código elegante é mais propenso a ser reutilizado, pois é mais fácil de compreender e aplicar em outros projetos.
- Confiabilidade: Código elegante tem menos erros e é mais fácil de testar, o que aumenta sua confiabilidade.
- Desempenho: Código elegante pode ser mais rápido e eficiente, pois é escrito de forma clara e concisa, sem trechos desnecessários de código.
- Colaboração: Código elegante é mais fácil de trabalhar em equipe, pois é mais fácil de entender e colaborar com outros desenvolvedores.

Em geral, escrever código elegante pode melhorar a qualidade do código, torná-lo mais fácil de manter e melhorar a produtividade dos desenvolvedores.

### Relação com Maus Cheiros

- Código duplicado: Afeta negativamente a elegância do código. Escrever código elegante envolve evitar a duplicação de código e reutilizar trechos de código onde é possível/necessário;
- Método longo: Métodos longos como o próprio nome sugere são trechos de código extensos e cansativos, portanto perde a característica de uma leitura tranquila e facilmente entedível ao programador;
- Longa lista de parâmetros: Por ter vários parâmetros, a chance de ocorrerem mudanças no futuro é grande e também causam uma certa confusão quando um novo programador que nao foi o responsável pelo desenvolvimento pega para estudar o método, além de trazerem inconsistência;
- Classe grande: Classes grandes possuem também o mesmo problema dos métodos longos, logo tornam a leitura cansativa e pouco produtiva ao programador;
- Mudanças divergentes: Em situações pontuais é necessário fazer alterações em uma classe e a complexidade do código pode ser aumentada caso essas mudanças não sejam bem implementadas, e com isso outro desenvolvedor terá problemas para tentar entender o código;
- Homem do meio: Métodos de uma classe delegam a execução para métodos de outras classes, causando confusão quanto ao princípio da responsabilidade única;
- Cirurgia com Rifle: Ao realizar uma mudança, várias classes devem sofrer modificações porém é difícil de identificar todos os locais afetados devido ao código não estar elegante.

### Refatoração

- Extrair Método: Separar um método pode ajudar a lidar com métodos longos, reduzindo sua extensão. Também pode concentrar elementos variáveis em uma única localização. Maus cheiros relacionados: método longo e mudanças divergentes.
- Extrair Classe/Subclasse: Agrupa variáveis juntas, tornando-as uma subclasse da classe relevante ou do projeto como um todo. Maus cheiros relacionados: Classe grande.
- Substituir Parâmetro por Método: Em vez de passar dados como parâmetro, o método do objeto que contém o dado é chamado, o que reduz a quantidade de parâmetros transmitidos. Maus cheiros relacionados: Longa lista de parâmetros.
- Mover Método: Método é retirado de uma classe e colocado em outra classe mais adequada. Isso é feito para ajudar a manter a coesão dos métodos e classes, tornando o código mais claro e fácil de manter. Maus cheiros relacionados: Cirurgia com rifle, Homem do meio.

## Modularidade

### Descrição

O desenvolvimento de um design de um problema envolve o processo de separá-lo em partes menos complexas, conhecidas como módulos ou componentes. Essas partes podem ser denominadas como subsistemas, bibliotecas, pacotes, classes, etc. Quando juntas, elas formam uma solução abrangente e completa ao problema original. A modularidade tem como características principais:

- **Alta coesão:** A coesão é uma métrica que avalia a integração e o desempenho conjunto das funções relacionadas em um módulo. Ela é responsável por manter o módulo coeso. Sem coesão, os componentes são desconexos e, para evitar isso, é necessário que cada módulo tenha uma função claramente definida.

- **Baixo acoplamento:** O acoplamento é uma medida da interdependência entre os módulos. Em projetos mais simples, os módulos apresentam baixo nível de acoplamento, o que os torna menos dependentes uns dos outros. No entanto, é impossível que os módulos sejam completamente desacoplados, já que eles precisam trabalhar juntos como parte de um sistema. Esses módulos podem se conectar de várias maneiras: diretamente, indiretamente, por meio de chamadas de funções em outros módulos ou por serem chamados por outros módulos. Eles também podem utilizar os tipos de dados de outros módulos ou compartilhar dados, como variáveis ou arquivos.

Em resumo, um design de software eficiente restringe as interações entre os módulos ao mínimo essencial. Estas interações formam parte da estrutura do código. Uma vez identificados, os módulos podem ser desenvolvidos e testados individualmente, o que é uma vantagem da modularização. Além disso, é possível dividir as tarefas entre os programadores, mas é importante ter cuidado para garantir que a decomposição seja lógica e baseada na solução do problema, em vez da organização da equipe.

### Relação com Maus Cheiros

Essa característica pode ter associada os seguintes maus cheiros:

- **Cirurgia com rifle:** Quando uma mudança é feita, muitas classes precisam ser alteradas. Pode ser desafiador localizar todos os pontos afetados e há o risco de esquecer alguma modificação.

- **Hierarquias de herança paralelas:** Se você incluir uma subclasse em um ramo, será necessário adicionar a mesma subclasse em outro ramo. Este é um exemplo de caso especial de cirurgia com rifle.

- **Inveja de recursos:** Dá-se quando os métodos de uma classe estão fortemente ligados aos recursos de outras classes (normalmente atributos). O uso excessivo de métodos get pode ser um sinal disso.

- **Classe preguiçosa:** O uso em excesso da divisão em módulos pode resultar em classes que não têm uma funcionalidade suficiente para justificar sua preservação no projeto.

- **Cadeias de mensagens:** Isso acontece quando um objeto convoca outro, que convoca outro, e assim por diante. Normalmente, isso é causado por meio de métodos Get. Também é uma indicação de alta interdependência, com o projeto fortemente vinculado à navegação dos métodos.

### Refatoração

Podem ser aplicadas as seguintes operações de refatoração:

- **Mover método ou mover campo:** consiste em mover o código de um método de uma classe para outra classe mais apropriada. O objetivo é melhorar a organização do código, torná-lo mais legível e fácil de manter, além de promover a responsabilidade única e a coesão.

- **Incorporar classe:** é um método de refatoração que consiste em integrar a funcionalidade de uma classe secundária na classe principal. Isso pode ser feito quando as classes são fortemente inter-relacionadas e a funcionalidade da classe secundária é melhor compreendida como parte da classe principal. O objetivo desse método de refatoração é aumentar a coesão, caso ela tenha sofrido prejuizo com o movimento de métodos e campos para outra classe.

- **Extrair método:** nos casos de Inveja de Recursos em que apenas uma parte do código da outra classe é afetada, é necessário corrigir essa dependência. Já nas situações de Cadeia de Mensagens, é importante separar a parte do código usada pelo cliente e transferi-la para o início da cadeia de mensagens.

## Alunos

| Matrícula | Nome                                |
| --------- | ----------------------------------- |
| 180042386 | Kevin Luis Apolinario Batista       |
| 170011119 | Geraldo Victor Alves Barbosa        |
| 170013987 | João Victor de Oliveira Matos       |
| 180042661 | Luís Fernando Furtado de Araújo     |
| 180018019 | Guilherme Daniel Fernandes da Silva |
| 180011600 | Ailton Aires Amado                  |
