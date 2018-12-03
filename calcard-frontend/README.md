# Calcard

Breve Descrição.

## Índice

- **[Metodologias](#metodologias)**
- **[Tecnologias](#tecnologias)**
- **[Métricas](#métricas)**
- **[Pré-requisitos](#pré-requisitos)**
- **[Instalação](#instalação)**
- **[Executando a aplicação](#executando-a-aplicação)**
- **[Build de Produção](#build-de-produção)**
- **[Gerando a documentação SASS](#gerando-a-documentação-sass)**
- **[Guidelines](#guidelines)**

## Metodologias

A aplicação foi projetada utilizando as seguintes metodologias de desenvolvimento:

- **[BEM Methodology](http://getbem.com/)** - convenção de nomenclatura para classes HTML e CSS.
- **[The 7-1 Pattern](https://sass-guidelin.es/#architecture)** - arquitetura SASS.

## Tecnologias

A aplicação foi projetada utilizando as seguintes tecnologias:

- **[Gulp](https://github.com/gulpjs/gulp)** - automação frontend.
- **[SASS(SCSS)](https://sass-lang.com/)** - pré-processador CSS.
- **[AngularJS](https://angularjs.org/)** - framework javascript.

## Métricas

O design, implementação e o fluxo de automação da aplicação foram projetadas para garantir as seguintes métricas:

- **Performance**
- **Progressive web app (PWA)**
- **Best pratices**
- **Accessibility**
- **SEO**

As auditorias foram feitas utilizando o **[Google Lighthouse](https://developers.google.com/web/tools/lighthouse/)**.

## Pré-requisitos

- A última versão do **[Node.js](https://nodejs.org/en/)**.

### Extensões VSCode

Para garantir convenções e estilo consistentes durante o desenvolvimento, é recomendável a seguinte configuração do VSCode:

- **[Prettier](https://marketplace.visualstudio.com/items?itemName=esbenp.prettier-vscode)**
- **[Stylelint](https://marketplace.visualstudio.com/items?itemName=shinnn.stylelint)**
- **[ESLint](https://marketplace.visualstudio.com/items?itemName=dbaeumer.vscode-eslint)**

Para integrar o autosave do prettier com o ESlint e stylelint, precisamos da seguinte configuração de usuário do VSCode:

```
"editor.tabSize": 2,
"files.eol": "\n",
"prettier.disableLanguages": ["html"],
"prettier.eslintIntegration": true,
"prettier.stylelintIntegration": true,
"eslint.autoFixOnSave": false,
"editor.formatOnSave": true
```

## Instalação

Na pasta raiz da aplicação:

```
npm install
```

## Executando a aplicação

Para executar a aplicação localmente em modo de desenvolvimento:

```
npm start
```

## Build de Produção

Esta build gera os arquivos compactados prontos para deploy.

```
npm run build
```

## Gerando a documentação SASS

A aplicação usa o **[sassdoc](http://sassdoc.com/)** para gerar a documentação do SASS.

```
npm run sassdoc
```

O comando irá gerar a pasta `sassdoc` no path raiz da aplicação.

## Guidelines

Para garantir convenções e estilo consistentes durante o desenvolvimento, as seguintes guidelines foram seguidas:

### SASS - Stylint

A aplicação usa o stylint para fazer o lint dos arquivos SASS e as seguintes configurações são usadas:

- **[stylelint-config-sass-guidelines](https://github.com/bjankord/stylelint-config-sass-guidelines)** baseado em **[sass guidelines](https://sass-guidelin.es/)**.
- **[stylelint-config-concentric-order](https://github.com/chaucerbao/stylelint-config-concentric-order)** baseado em **[concentric-CSS](https://github.com/brandon-rhodes/Concentric-CSS/blob/master/style3.css)** para ordenar as propriedades CSS.

### JavaScript- ESlint

A aplicação usa o ESlint para fazer o lint dos arquivos javascript e as seguintes configurações são usadas:

- **[eslint-plugin-angular](https://www.npmjs.com/package/eslint-plugin-angular)** baseado no [guideline do John Papa](https://github.com/johnpapa/angular-styleguide/tree/master/a1).
