class ClassProcessor
{
	TypeManager typeManager
	Config config
	DefinitionWriter definitionWriter
	ISpecialCases specialCases
	AliasManager aliasManager
	PropertyProcessor propertyProcessor
	MethodProcessor methodProcessor

	def init() {
		specialCases = new SpecialCasesExtJS420()
		aliasManager = new AliasManager( config: config, typeManager: typeManager )
		aliasManager.init()
		propertyProcessor = new PropertyProcessor( typeManager: typeManager, config: config, definitionWriter: definitionWriter, specialCases: specialCases )
		propertyProcessor.init()
		methodProcessor = new MethodProcessor( typeManager: typeManager, config: config, definitionWriter: definitionWriter, specialCases: specialCases )
		methodProcessor.init()
	}

	def processClass( className, fileJson ) {
		def processedNames
		aliasManager.addAliases( className, fileJson )

		definitionWriter.writeToDefinition( "\texport interface I${ typeManager.getClassName( className ) } ${ typeManager.getExtends( fileJson, true ) } {" )
		if( !fileJson.singleton ) {
			processedNames = writeProperties( fileJson, true, false )
			writeMethods( fileJson, processedNames, true, false )
		}
		definitionWriter.writeToDefinition( "\t}" )

		if( !config.interfaceOnly || fileJson.singleton ) {
			if( !config.interfaceOnly ) {
				definitionWriter.writeToDefinition( "\texport class ${ typeManager.getClassName( className ) } ${ typeManager.getExtends( fileJson, false ) } implements ${typeManager.getImplementedInterfaces( fileJson ) } {" )
				processedNames = writeProperties( fileJson, false, false )
			}
			else {
				definitionWriter.writeToDefinition( "\texport class ${ typeManager.getClassName( className ) } {" )
				processedNames = [:]
			}

			writeMethods( fileJson, processedNames, false, false )
			definitionWriter.writeToDefinition( "\t}" )
		}
	}

	def writeProperties( fileJson, isInterface, useExport ) {
		propertyProcessor.writeProperties( fileJson, isInterface, useExport )
	}

	def writeMethods( fileJson, processedNames, isInterface, useExport ) {
		methodProcessor.writeMethods( fileJson, processedNames, isInterface, useExport )
	}
}