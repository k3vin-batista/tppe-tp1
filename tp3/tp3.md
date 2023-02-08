# TPPE - TP3

Repositório para o trabalho prático 3 da disciplina Tópicos de Programação para Plataformas Emergentes - UnB 2022/2

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
- Mover Método: Método é retirado de uma classe e colocado em outra classe mais adequada. Isso é feito para ajudar a manter a coesão dos métodos e classes, tornando o código mais claro e fácil de manter. Maus cheiros relacionados: Cirurgia com rifle, Homem do meio


## Alunos

| Matrícula | Nome                                |
| --------- | ----------------------------------- |
| 180042386 | Kevin Luis Apolinario Batista       |
| 170011119 | Geraldo Victor Alves Barbosa        |
| 170013987 | João Victor de Oliveira Matos       |
| 180042661 | Luís Fernando Furtado de Araújo     |
| 180018019 | Guilherme Daniel Fernandes da Silva |
| 180011600 | Ailton Aires Amado                  |
