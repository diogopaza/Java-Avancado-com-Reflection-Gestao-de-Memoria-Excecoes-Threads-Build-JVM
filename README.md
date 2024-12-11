# Java-Avancado-com-Reflection-Gestao-de-Memoria-Excecoes-Threads-Build-JVM

<h2>Generics</h2>
<p>São mecanismos que nos permitem escrever códigos sem se importar com os tipos de objetos 
que serão manipulados. Generics em Java permite criar classes, interfaces e métodos que operam com tipos de dados especificados no momento da instância.</p>
<p>Generics não funcionam com tipos primitivos (int, char, etc).</p>


<h2>Excecoes</h2>
<p>Java tem dois tipos de excecoes: excecoes verificadas pelo compilador do Java (Checked Exceptions), verifica se está sendo feito o tratamento,
ou seja, obriga a tratar com try/catch ou obriga a jogar a exceção para cima, em um momento sera necessario
resolver a excecao. Checked Exceptions herdam de Exception, o compilador torna obrigatório seu tratamento.</p> E temos as excecoes Unchecked Exceptions que são as excecoes nao verificadas e herdam
de RunTimeException, ou seja, o compilador não torna obrigatorio o seu tratamento.
<p>Toda excecao e derivada de um objeto Throwable, que como qualquer objeto Java e derivado de um Object.</p>
<h3>Spring - GlobalExceptionHandler</h3>
<p>Existe uma RFC padrao para o retorno das mensagens == RFC 7807</p>
<p>@ExceptionHandler(Exception.class) precisa da classe @RestController - quando ocorre uma exceção em qualquer controlador REST,
o Spring procura metodos anotados com @EsceptionHandler dentro das classes anotadas com @RestControllerAdvice.</p>

<h3>Criando um execao CORINGA</h3>
<p>A excecao coringa e para capturar excecoes genericas.</p>

<h2>Maven</h2>
<p>Repositorio central do Maven: https://mvnrepository.com/</p>

<h3>Adicionando um repositorio</h3>
<repositories>
        <repository>
            <id>clojars.org</id>
            <url>https://repo.clojars.org/</url>
        </repository>
    </repositories>

<h3>Ciclo de vida do Maven</h3>
Validate -> Compile -> Test -> Package -> Verify -> Install -> Deploy

<h3>Perfis</h3>

<h3>Rodar sem testes o Maven</h3>
<p>Clica com lado direito em package e adiciona ao comando o -DskipTests</p>

<p><build>
		<finalName>adopet-api</finalName> aqui altera o nome do .jar</p>

<h3>Plugins</h3>
<p>Servem para moficar o build da aplicação:: usado como exemplo o pmd para gerar um relatorio com erros e melhorias para o projeto, 
tambem foi definido que em caso o build deve falhar.</p>
<p>Plugin pmd:: <plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-pmd-plugin</artifactId>
				<version>3.26.0</version>
				<executions>
					<execution>
						<goals>
							<goal>check</goal>
							<goal>cpd-check</goal>
						</goals>
					</execution>
				</executions>
			</plugin></p>
<p>mvn clean verify == precisa ser o verify por que o package nao passa pelo verify (ciclo de cida do maven)</p>

<h3>Build com relatorio de testes - Jacoco</h3>
<p>adiciona o plugin e apos o build cria uma pagina com o relatorio de testes na pasta target/site/jacoco</p>

<h3>Escopo de dependencias</h3>
<p>O Maven permitir definir escopos para suas dependencias. Isso e util para especificar quando uma dependencia e necessaria. 
 compile: O padrão indica que a dependência é necessária para compilar e executar o projeto.
provided: Usado para dependências que são fornecidas pelo ambiente de execução (como um servidor web), e não devem ser incluídas no pacote final.
runtime: A dependência não é necessária para compilar, mas é para execução.
test: A dependência é usada apenas para testes.</p>
<dependency>
    <groupId>com.exemplo</groupId>
    <artifactId>libX</artifactId>
    <version>1.0</version>
    <scope>test</scope>
</dependency>

<h3>Maven / Proxy</h3>
<p>O Maven e uma ferramenta de gerencviamento, construção e implantação de projetos muito interessante.
Ajuda no processo de gerenciamento de dependencias e no de de build, geracao de relatorios e de documentacao. </p>
<p>Minimo de um arquivo pom.xml:</p>
<p><project>   <modelVersion>4.0.0</modelVersion>   <groupId>br.com.caelum</groupId>   <artifactId>teste</artifactId>   <version>1.0</version> </project></p>
<p>groupId: identificador da empresa/grupo ao qual o projeto pertence</p>
<p>artifactId:nome do projeto</p>
<p>version: versao atual do projeto</p>
<h3>Modularizar a aplicação Produtos/Meteoro</h3>

<p>Gerenciamento de dependencia</p>
<p>Controle de dependencias, principal funcao do Maven.</p>
<p>Maven guarda todos os jars baixados na pasta m2_home, assim se mais de um projeto seu depende do mesmo jar, ele nao e baixado denovo.</p>

<p>Utilizacao de plugins</p>

<ul>
    <li>dividir os times por módulos</li>
    <li>separar as dependencias</li>    
</ul>
<p>dependencyManagement  == estudar sobre isso noa entrou no curso</p>
<p>POM do pai == <groupId>br.com.diogo</groupId>
    <artifactId>meteora</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>pom</packaging>
    <modules>
        <module>anuncio</module>
        <module>produtos</module>
    </modules></p>
    <p>Importante observar que o pom.xml do projeto pai o packaging é apenas pom, ou seja, apenas empacotar os modulos.</p>
    <p>Também é possível adicionar uma dependencia no modulo pai e esta dependencia estara disponivel apra todos os modulos filhos. Funciona de uma
    forma semelhante a herança.</p>

<p>POM DO FILHO == <groupId>br.com.diogo</groupId>
    <artifactId>meteora</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>pom</packaging>
    <modules>
        <module>anuncio</module>
        <module>produtos</module>
    </modules></p>


<h2>Threads</h2>
<p>Tarefas sincronas ou assincronas</p>
<p>Simulando tarefas paralelas</p>
<p>Java e a primeira linguagem de programacao a incluir o conceito de threads na propria linguagem</p>
<p>A classe Thread do pacote java.lang e utilizada para programar linhas de execucao paralelas</p>
<p>Criar o metodo run com a instrucao que sera executada</p>
<p>Há duas maneiras de implentar Threads em Java, ou estende da classe Thread, ou implementa
a interface Runnable</p>
<p>Executar o metodo start()</p>
<p>Exemplo imprimir For de Threads == temos resultado nao deterministico, ou seja, nao existe 
uma ordem definida para execucao de Threads.</p>
<p>Com o uso da palavra synchronized so e permitada a execucao de uma Thread por vez naquele metodo, 
bloqueando ate o termino da Thread.</p>
<p>Com onuso do metodo join() a Thread main espera as outras Threads serem executadas, para entao
finalizar suas tarefas</p>
<p>setPriority(10); //10 tem amis prioridade 1 menor prioridade</p>
<p>metodo isAlive() == imprime um boolean indicando se a Thread esta ativa ou nao</p>
<h2>Uma coisa é verifica situacao diferente e usar processamento paralelo com Spring Boot por exemplo, o
Spring Boot trata as Threds de sua propria maneira. </h2>
<p>E necessario usar recursos do proprio Spring Boot. Criar Lock no Spring:: </p>
<p>@Version usa no Spring Boot</p>
<p>@Version e um lock otimista</p>
<p>PESSIMISTIC_FORCE_INCREMENT usando o Lock Pessimista no repository, qualquer consulta (select) ou outra 
movimentacao no banco a versao e alterada</p>

<h2>Criando Threads no Spring</h2>
<p>Para crair assincronismo == @EnableAsync na classe prinicpal</p>
<p>@Async no metodo == cria nova thread</p>
<p>Envio de pedido sem uso de Threads == 3.21 segundos com uso de Threads tempo == 57 ms</p>
<p>O Spring tem uma arquitetura chamada de bloqueante se 5 pessoas fazem 5 requisicoes o Spring cria 5 Threads. Com o @Async nos temos
uma arquitetura nao bloqueante. </p>
<h2>Configurando as Threads criadas pelo Spring</h2>
<p>Metodos de consulta de banco de dados, tambem podem usar async dessa forma fazem as consultas de forma paralela.</p>
<p>        CompletableFuture.allOf(estoqueZerado, faturamentoObtido).join(); == esse metodo da classe CompletableFuture espera
as Threads terminarem (no caso estoqueZerado e faturamentoObtido ficam sincronizados) e ai depois volta para a Thread atual.
</p>
<h2>Resolvendo problema de criação de muitas Threads:: </h2>

<h2>Threads Virtuais == nova funcionalidade do Java 21</h2>
<p>As Threads virtuais passam pela JVM, antes de serem enviadas ao SO.</p>
<p>No application.properties adicionar Threads virtuais == spring.threads.virtual.enabled=true</p>

<h2>Gestao de memoria em Java</h2>







<h4>Referencias</h4>
<p><sub>Java Generics: Quando Usar e Quando Evitar - site medium</sub></p>
<p><sub>https://medium.com/@rafael.porto/mvp-de-um-e-commerce-na-aws-totalmente-automatizado-usando-derramentas-de-infrastrutura-como-ac39d45948b7</sub></p>
<p><sub>https://www.ime.usp.br/~gold/cursos/2004/mac438/aulaJava.pdf</sub></p>
