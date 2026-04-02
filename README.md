[README-original.md](https://github.com/user-attachments/files/26425074/README-original.md)

# Sistema de Olimpíada de Questões (Ucsal) — Refatoração SOLID

Este projeto consiste na refatoração de um sistema de gestão de provas e participantes, originalmente estruturado em uma única classe procedural, para um modelo orientado a objetos seguindo os princípios de design **SOLID** e padrões de projeto.

## 🛠 Principais Mudanças na Arquitetura

A principal mudança foi a **descentralização da lógica**. O código original concentrava toda a execução (entrada de dados, validação e regras de negócio) na classe `App`. 

1.  **Separação em Camadas:** Criamos pacotes específicos para `entidades`, `cadastros` e `logica de execucao`.
2.  **Polimorfismo de Questões:** A introdução de uma classe abstrata `Questao` permitiu que o sistema suporte diferentes tipos de perguntas (Múltipla Escolha e Xadrez/Seed) sem alterar o motor da prova.
3.  **Injeção de Dependências:** As classes de serviço deixaram de instanciar suas próprias listas, passando a receber as dependências necessárias via construtor.
4.  **Template Method:** Padronização do fluxo de criação de objetos através de uma hierarquia de cadastradores.

---

## 📐 Aplicação dos Princípios SOLID

Abaixo, detalhamos onde cada princípio foi aplicado no código refatorado:

### 1. S — Single Responsibility Principle (Princípio da Responsabilidade Única)
Cada classe agora possui uma única razão para mudar.
* **Exemplo:** A classe `AplicadorProva` é responsável apenas por orquestrar o fluxo da prova. Ela não sabe como cadastrar um participante ou como imprimir um tabuleiro de xadrez; ela delega essas funções para as classes especialistas.

### 2. O — Open/Closed Principle (Princípio Aberto/Fechado)
O sistema está aberto para extensão, mas fechado para modificação.
* **Exemplo:** Para adicionar um novo tipo de questão (ex: Verdadeiro ou Falso), não precisamos modificar a classe `App` ou o `AplicadorProva`. Basta criar uma nova classe que estenda `Questao`. O sistema aceitará o novo tipo automaticamente através do polimorfismo.


### 3. L — Liskov Substitution Principle (Princípio da Substituição de Liskov)
Subclasses podem substituir suas classes base sem quebrar a aplicação.
* **Exemplo:** A lista `List<Questao>` no `AplicadorProva` armazena tanto `QuestaoMultiplaEscolha` quanto `QuestaoSeed`. O método `aplicar()` chama `q.exibir()` e `q.validarResposta()` sem precisar saber o tipo real do objeto, e ambos se comportam conforme o esperado.

### 4. I — Interface Segregation Principle (Princípio da Segregação de Interface)
Interfaces específicas são melhores que uma única interface genérica "faz-tudo".
* **Exemplo:** A interface `ICadastrador` define apenas o contrato essencial para a criação de novos registros, garantindo que as implementações não sejam forçadas a herdar métodos que não utilizam.

### 5. D — Dependency Inversion Principle (Princípio da Inversão de Dependência)
Dependa de abstrações, não de implementações concretas.
* **Exemplo:** As classes de cadastro e aplicação recebem o `Scanner` e as `Listas` via construtor. Isso significa que essas classes não dependem de como os dados são armazenados ou de onde vem a entrada do usuário, facilitando a manutenção e futuros testes unitários.

---

## 🏗 Padrões de Projeto Utilizados

* **Template Method:** Aplicado na classe abstrata `CadastroQuestao`. Ela define o passo a passo do algoritmo de cadastro (selecionar prova -> pedir enunciado), mas deixa o passo `cadastrarEspecifica` para ser implementado pelas subclasses.

* **Expert Pattern (Information Expert):** A lógica de calcular acertos foi movida para dentro da classe `Tentativa`, pois ela possui todas as informações necessárias para realizar esse cálculo, mantendo o encapsulamento.

---

## 🚀 Como Executar

1. Certifique-se de ter o **JDK 25** instalado.
2. Compile o projeto: `javac br/com/ucsal/olimpiadas/*.java`.
3. Execute a classe principal: `java br.com.ucsal.olimpiadas.App`.
4. O sistema iniciará com uma **Seed** (dados pré-carregados) contendo um problema de xadrez para teste imediato.
