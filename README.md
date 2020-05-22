# Gestor de Microempreendimento culinário
*Projeto universitário voltado para gestão de pequenos empreendimentos de profissionais autônomos*

## Objetivo

O Gestor de Microemprendimento culinário (GMEC) foi um projeto desenvolvido para a disciplina de Laboratório de Engenharia de Software, durante o curso de Análise e Desenvolvimento de Sistemas da Fatec de Presidente Prudente.  Seu objetivo é simplificar e agilizar a gestão de pequenos negócios do segmento culinário, fornecendo relatórios úteis para uma tomada de decisão mais eficiente.

## Funcionalidades

- Autenticação e gestão de usuários
- Registro de vendas
- Cadastro de produtos
- Gerenciamento de clientes
- Relatórios de negócio baseados em faixas de tempo
- Gestão de encomendas
- Notificação de encomenda baseada em data

## Tecnologias utilizadas

- **Ambiente de Desenvolvimento:** Netbeans 8.2
- **Banco de dados relacional:** MySQL 5.3
- **Ferramenta de acesso ao MYSQL:** MySQL Workbench
- **Plataforma de execução:** Oracle JDK 8
- **Toolkit gráfico utilizado:** Java swing
- **Arquitetura de software emulada:** MVC

### Bibliotecas externas

1. JCalendar - disponível em: [https://toedter.com/jcalendar/](https://toedter.com/jcalendar/ "https://toedter.com/jcalendar/")
2. Java MySQL connector disponível em: [https://dev.mysql.com/downloads/connector/j/5.1.html](https://dev.mysql.com/downloads/connector/j/5.1.html "https://dev.mysql.com/downloads/connector/j/5.1.html")

## Execução

### Instruções

Para executar o GMEC realize os seguintes passos:

1. Abra a modelagem *database new* (presente na pasta database) no Workbench e crie o banco de dados
2. Certifique-se de que as informações de conexão com o banco, especificadas na classe *infoBanco*, estejam corretas. 
3. Abra o projeto no Netbeans e resolva os problemas de bibliotecas apontando para os arquivos delas no diretório raiz do projeto
4. Execute a aplicação 

### Sistema operacional

O GMEC funciona em qualquer SO. Para integração visual, ele conta com suporte aos temas do Windows, Linux (GTK) e Mac OS. Para adicionar novos temas ao sistema altere a string de look no método abaixo presente na classe [login.java](https://github.com/Fefefx/Gestor_de_microempreendimento_culinario/blob/master/gmec/src/UI/login.java "login.java"):

```java
    /*Verifica o sistema operacional e aplica o tema padrão do mesmo ao GMEC. 
     Caso o S.O. seja diferente do especificado, imprime mensagem de erro e usa o tema Nimbus.  */  
    public void LookAndFeel() {
        String look="";
        String text = System.getProperty("os.name");
        if (text.contains("Windows")) {
            look = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        } else if (text.equals("Linux")) {
            look = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
        } else if(text.contains("Mac")){
            look = "com.sun.java.swing.plaf.mac.MacLookAndFeel";
        }
        try {
            UIManager.setLookAndFeel(look);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.out.println("Erro ao aplicar tema !");
        }
```
