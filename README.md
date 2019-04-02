# Gradle lfruploader Plugin
![Gradle](https://plugins.gradle.org/shared-assets/shared/images/gradle-logo-horizontal.svg)
lfruploader es un plugin de Gradle preparado para subir de forma sencilla modulos a servidores.
En ocasiones los entornos de desarrollo estan ubicados en servidores y su utilización es de pocas personas, por
lo que no es consistente usar [Jenkins](https://www.osgi.org), lfruploader establece una conexión
por tres tipos de canales SFTP(SSH), FTP y FTPS, incluso esta preparado para realizar subidas a entornos de AWS
incluyendo KeyStore. Gracias a este plugin podremos realizar subiads tanto de todos los componentes como de uno en uno
gracias a Gradle.

## Descarga
Puedes descargarlo desde: ${link}

## Instalación
Para utilizar el plugin dentro de Gradle solo tendremos que realizar los siguientes cambios dentro del build.gradle:


```
buildscript{
    repositories {
        mavenLocal()

        dependencies{
            classpath 'com.everis.apolalca:lfruploader:1.0'
        }
    }
}

apply plugin: "lfruploader"
```
[- Como añadir plugins a los subprojectos.](https://docs.gradle.org/current/userguide/plugins.html#sec:subprojects_plugins_dsl)

Uso del plugin en Gradle:
````
 ./gradlew lfruploader
````
lfruploader realiza una compilación antes de realizar la subida, en caso de no querer realizar la compilación ver en 'Configuración'.
## Configuraciones
Configuración basica:
```

lfruploader {
    uploaderConfiguration {
        connection = "SFTP"
        host = "xx.xx.xx.xx"
        user = "root"
        pass = "root"
        port = "22"
        into = "/temp/project/"
    }
}

```


Gracias a 'liferay' podremos especificar al modulo su versión, con esta configuración activa el modulo
comprueba que en caso de ser una versión inferior a 7 (no existe [OSGI](https://jenkins.io)) se implantarán los siguientes modulos en las
siguientes ubicaciones:
* jar: Se implantará dentro de tomcat/lib/ext
* war: Se impatará dentro de deploy
Las configuraciones de tomcat se especifican desde el parametro 'tomcatPath' anteriormente especificado.
