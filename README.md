# Seminário — Métricas de Acoplamento & Design

Demonstração prática para a disciplina de Manutenção e Melhoria de Software.
Explora acoplamento, dependências cíclicas e métricas de design usando o
**Sonargraph** (hello2morrow) sobre o Spring PetClinic.

## Estrutura
- `petclinic_saudavel/` — Spring PetClinic original, sem ciclos de dependência
  entre pacotes. Referência de design saudável (grafo acíclico).
- `petclinic_injetada/` — mesma base, com um **acoplamento cíclico introduzido
  de propósito** entre os pacotes `model` e `vet`: a classe `model.NamedEntity`
  passa a depender de `vet.Specialty`, e `vet` já dependia de `model`, fechando
  o ciclo. Usado para demonstrar a detecção de ciclos e a violação do
  Acyclic Dependencies Principle (ADP).

## O que a demo mostra
1. Grafo e matriz de dependências dos pacotes (saudável vs injetada).
2. Detecção de acoplamento cíclico (Cycle Groups no Sonargraph).
3. Métricas de acoplamento de Robert C. Martin: acoplamento aferente/eferente,
   instabilidade e abstração.
4. Proposta de desacoplamento via inversão de dependência (extrair interface).

## Como reproduzir
Requer JDK 17+. Em cada pasta:

    ./mvnw compile

Depois, no Sonargraph: File > New > Java System Based On Build Unit(s),
apontando para a pasta do projeto (usa target/classes + src/main/java) e F5
para analisar.

## Créditos
Baseado no Spring PetClinic (https://github.com/spring-projects/spring-petclinic),
licenciado sob Apache License 2.0. As modificações em petclinic_injetada são
intencionais e apenas para fins didáticos.
