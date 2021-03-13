# ZeDeliveryMobile  
Projeto de automação de testes mobile, escrito em JAVA, para testes da aplicação Zé Delivery  

[Arquivo com a primeira parte do teste!](https://github.com/Kasousa/ZeDeliveryMobile/blob/master/QAChallenge.docx)

## Instalação  

1 - Clone o projeto do git com o comando:  
**git clone https://github.com/Kasousa/ZeDeliveryMobile.git**  
2 - Utilize a IDE de sua preferência, Eclipse, Intelij.. importando o projeto como maven e aguardando serem baixadas todas as dependências  

## Execução

1 - Via linha de comando, enviando comando "mvn test"  
2 - Clicando com o botão direito na classe "BaseTest" e selecionando a opção "Run"  

## Sobre o framework  

- configs -> Pasta com o arquivo de configurações do framework (URL base e API Key)
- src 
    - main  
    - test
        - java
            - org.zedelivery
                - actions -> Classes com as ações (Cliques, Escritas, Swipes)
                - dataProvider -> Pasta com a classe que gerencia os dados do framework
                - features -> Arquivos .feature com a escrita BDD do Cucumber
                - screens -> Classes com a declaração dos elementos
                - steps -> Classes com o passo a passo dos testes
                - support -> Classes de suporte
                - BaseTest -> Classe para execução dos testes do Cucumber
        - resources
            - massa -> Pasta com os arquivos de massas de dados utilizadas no teste
            - properties -> Pasta com arquivo de propriedades do framework

&copy; Kaique Santos Sousa - 2021
