# Google Tasks Clone

<table>
  <tr>
    <td valign="top">
      <h2>📌 Sobre o Projeto</h2>
      <h4>Esse projeto é um clone do aplicativo Google Tarefas, desenvolvido com o objetivo de reforçar e validar conhecimentos em:</h4>
    </td>
    <td style="padding-left: 20px;">
      <img src="https://raw.githubusercontent.com/github/explore/refs/heads/main/topics/google-tasks/google-tasks.png" alt="Imagem do Google Tasks" width="250"/>
    </td>
  </tr>
</table>

* **Kotlin**
* **XML (Views tradicionais)**
* **Room Database**
* **RxJava**
* **Arquitetura MVP**
* **Clean Architecture**
* **Padrão Single Activity**
* Boas práticas gerais da linguagem e do ecossistema Android

<table>
  <tr>
    <td valign="top">
      <h2>📌 Arquitetura</h2>
      <h4>O projeto utiliza uma combinação de <span style="color: #3b8640;"><b>MVP + Clean Architecture</b></span>, separando bem as camadas para facilitar manutenção e teste:</h4>
    </td>
    <td style="padding-left: 20px;">
      <img src="https://raw.githubusercontent.com/github/explore/refs/heads/main/topics/google-tasks/google-tasks.png" alt="Imagem do Google Tasks" width="250"/>
    </td>
  </tr>
</table>

* **Presentation** → Fragments + Presenter
* **Domain** → Task
* **Data** → Repository + DAO + Entities
* **Implementação** → Room + RxJava

<table>
  <tr>
    <td valign="top">
      <h2>📌 Tecnologias Implementadas</h2>
      <h4>...................................................................................................................................................................................</h4>
    </td>
    <td style="padding-left: 20px;">
      <img src="https://raw.githubusercontent.com/github/explore/refs/heads/main/topics/google-tasks/google-tasks.png" alt="Imagem do Google Tasks" width="180"/>
    </td>
  </tr>
</table>

### **Room**
Utilizado para persistência local das tarefas.

### **RxJava**
Responsável pelo fluxo assíncrono de dados entre camadas.

### **MVP**
Separação clara entre UI e lógica de apresentação.

### **Clean Architecture**
Camadas bem definidas e independentes.

### **Kotlin Features**

* Data classes
* Null-safety
* Scoping functions (`apply`, `let`, `also` etc.)

<table>
  <tr>
    <td valign="top">
      <h2>📌  Funcionalidades do App</h2>
      <h4>...................................................................................................................................................................................</h4>
    </td>
    <td style="padding-left: 20px;">
      <img src="https://raw.githubusercontent.com/github/explore/refs/heads/main/topics/google-tasks/google-tasks.png" alt="Imagem do Google Tasks" width="180"/>
    </td>
  </tr>
</table>

* Criar tarefas
* Atualizar tarefas
* Marcar como favorita
* Excluir
* Listagem em tempo real com RxJava
* Tela baseada em **Single Activity + múltiplos Fragments**

<table>
  <tr>
    <td valign="top">
      <h2>📌 Como Rodar o Projeto</h2>
      <h4>...................................................................................................................................................................................</h4>
    </td>
    <td style="padding-left: 20px;">
      <img src="https://raw.githubusercontent.com/github/explore/refs/heads/main/topics/google-tasks/google-tasks.png" alt="Imagem do Google Tasks" width="180"/>
    </td>
  </tr>
</table>

1. Clone o repositório:

   ```bash
   git clone https://github.com/ThiagoSGomes-Dev/google-tasks-clone.git
   ```

2. Abra no **Android Studio**

3. Sincronize o projeto

4. Execute em um dispositivo/emulador

<table>
  <tr>
    <td valign="top">
      <h2>📌 Prévia</h2>
      <h4>...................................................................................................................................................................................</h4>
    </td>
    <td style="padding-left: 20px;">
      <img src="https://raw.githubusercontent.com/github/explore/refs/heads/main/topics/google-tasks/google-tasks.png" alt="Imagem do Google Tasks" width="180"/>
    </td>
  </tr>
</table>

## Objetivo

Este projeto foi criado com foco **educacional**, para consolidar habilidades essenciais no desenvolvimento Android.
