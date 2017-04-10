Command-line application

Used standart xml SAX parser.
All actions are declared in commandConfig.xml file, and App.java class parses it to find out how to run commands by it's shortcut name. 
By changing/adding new commands in commandConfig.xml file one can extend the program with new shortcut actions. 
I have used jaxb2 for parsing commandConfig.xml file inside the application

Following actions are available now:
1. Checks incoming xml file to see xsd or dtd.
Command: java App scanxml c:\config.xml c:\config.xsd
		"App" is mainClass
		"scanxml" is command which is indicated in CommandConfig.xml
		
2. Counts the number of elements in the xmlFile.
Command: java App elementCount c:\test.xml staff
		"elementCount" - is command indiated in commandConfig.xml
		"staff" is some tag in test.xml file.