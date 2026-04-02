[README-original.md](https://github.com/user-attachments/files/26425074/README-original.md)
# Olimpíadas de Questões

## Visão Geral

Sistema de olimpíadas de questões desenvolvido em Java puro, sem frameworks externos. Permite cadastrar participantes, provas e questões, aplicar provas a participantes e visualizar o histórico de tentativas.

---

## Estrutura de Pacotes

```
br.com.ucsal.olimpiadas
├── App.java                          # Ponto de entrada, estado global e menu principal
├── AplicadorProva.java               # Lógica de aplicação de prova a um participante
├── ProvaSeed.java                    # Populador de dados iniciais
│
├── cadastros/
│   ├── ICadastrador.java             # Interface de contrato para cadastros
│   ├── CadastroParticipante.java     # Cadastro de participantes
│   ├── CadastroProva.java            # Cadastro de provas
│   └── questao/
│       ├── CadastroQuestao.java      # Classe abstrata base para cadastro de questões
│       ├── CadastroQuestaoMultiplaEscolha.java  # Cadastro de questão de múltipla escolha
│       └── CadastroQuestaoSeed.java  # Cadastro de questão pré-definida (xadrez)
│
└── entidades/
    ├── Participante.java             # Entidade participante
    ├── Prova.java                    # Entidade prova
    ├── Resposta.java                 # Entidade resposta de uma questão
    ├── Seletor.java                  # Utilitário de seleção interativa via console
    ├── Tentativa.java                # Entidade tentativa + listagem de histórico
    └── questao/
        ├── Questao.java              # Classe abstrata base para questões
        ├── QuestaoMultiplaEscolha.java  # Questão de múltipla escolha (A-E)
        └── QuestaoSeed.java          # Questão pré-definida de xadrez (mate em 1)
```

---

## Funcionalidades

- **Cadastrar Participante** — registra um participante pelo nome
- **Cadastrar Prova** — registra uma prova pelo título
- **Cadastrar Questão** — adiciona uma questão de múltipla escolha a uma prova existente
- **Aplicar Prova** — seleciona um participante e uma prova, exibe as questões e registra as respostas
- **Listar Tentativas** — exibe o histórico de todas as tentativas com a nota obtida
- **Prova Seed** — ao iniciar, o sistema já carrega automaticamente uma prova de xadrez com uma questão pré-definida

---

## Tipos de Questão

### Múltipla Escolha
Questão com 5 alternativas (A a E). O participante responde com a letra correspondente. A validação é feita comparando a inicial da resposta com a alternativa correta, ignorando maiúsculas/minúsculas.

### Questão Seed (Xadrez)
Questão pré-definida de mate em 1 no xadrez. Exibe o tabuleiro renderizado no console a partir de uma string FEN. A resposta correta é uma jogada em notação algébrica (ex: `Qc8#`).

---

## Exemplo de Uso

```
=== OLIMPÍADA DE QUESTÕES (V1) ===
1) Cadastrar Participante
2) Cadastrar Prova
3) Cadastrar Questão em uma prova
4) Aplicar Prova (selecionar participante + prova)
5) Listar tentativas (resumo)
0) Sair
> 1
Nome: João
Participante Cadastrado. ID: 1

> 4
Participantes
  1) João

Escolha o id do participante: 1

Provas:
  1) Prova Seed

Escolha o id da prova: 1

--- Início da Prova ---

Questão #1
---TABULEIRO DE XADREZ---
...
Resposta: Qc8#

--- Prova Finalizada ---
Nota: 1/1
```

---

## Tecnologias

- Java 21
- Sem frameworks externos
- Apenas biblioteca padrão do JDK (`java.util`, `java.util.Scanner`)
