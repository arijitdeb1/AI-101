# Demystifying GitHub CoPilot

## Context
All contexts referred by GitHub Copilot for generating a response
- Opened Current file
- Opened nearby tab/files
- Code around cursor
- Comments and Documentation
- Language Syntax and Semantics
- History and Patterns
- User Input

## Registration
Register for 'Individual' account at [GitHub Copilot](https://copilot.github.com/)
Below settings are available for Copilot during registration
![ScreenShot](/images/copilot-policies.PNG?raw=true)

## IntelliJ IDE Setup
1. Intellij >> Settings >> Plugin >> search and install GitHub Copilot plugin and restart IDE
2. Sign to GitHub Copilot as suggested over IDE

![ScreenShot](/images/copilot-signin.PNG?raw=true)

3. Copilot settings over IDE (can be changed if required or else keep default)
![ScreenShot](/images/copilot-settings-IDE.PNG?raw=true)  
4. GitHub Copilot icons will be available at top right corner of IDE. One icon for code completions and another for suggestions/chat.

![ScreenShot](/images/copilot-icon.PNG?raw=true) 

5. Copilot suggestions and code completions will be available as you start typing in the editor.
![ScreenShot](/images/coplilot-suggestions1.PNG?raw=true) 

Copilot completions help in generating code snippets, comments, documentation, and even test cases.
![ScreenShot](/images/copilot-code-completions.PNG?raw=true)


## GitHub CLI Setup
1. download [GitHub CLI](https://cli.github.com/) and install.
2. Open Command prompt >> `gh auth login` >> follow the steps to authenticate by web browser. select below options
   ![ScreenShot](/images/gh-auth-login.PNG?raw=true)
3. Install copilot in cli >> `gh extension install github/gh-copilot`
4. Pass your prompt as follows - `gh copilot explain "give me echo command to greet hello world"`

![ScreenShot](/images/copilot-CLI-response.PNG?raw=true)

## Code Review based on Coding Standards
Code Review based on coding standards defined in yaml format in below files -

[java_coding_standards.yaml](https://github.com/arijitdeb1/AI-101/blob/main/java_coding_standards.yaml)
[spring_coding_standards.yaml](https://github.com/arijitdeb1/AI-101/blob/main/spring_boot_coding_standards.yaml)

open the file in IDE(in any Tab) and run the below prompt to review the code.
![ScreenShot](/images/coding-standard.PNG?raw=true)


In GitHub Copilot Chat, type the below command 
`/help` - to get the list of commands available








