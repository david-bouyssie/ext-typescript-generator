import groovy.json.JsonSlurper

class SpecialCases implements ISpecialCases {

	def specialCases = [:]

	SpecialCases() {
		createSpecialCases()
	}

	def createSpecialCases() {
		specialCases[ "removeProperty" ] = [:]
		specialCases[ "removeMethod" ] = [:]
		specialCases[ "methodToProperty" ] = [:]
		specialCases[ "globalReturnTypeOverride" ] = [:]
		specialCases[ "returnTypeOverride" ] = [:]
		specialCases[ "convertParamType" ] = [:]
		specialCases[ "forcedInclude" ] = [:]
		specialCases[ "rewriteMethod" ] = [:]
		specialCases[ "propertyTypeOverride" ] = [:]
		specialCases[ "addClass" ] = [:]

		//		addRemovedProperty( "Ext.grid.column.Action", "isDisabled" )
		//		addRemovedProperty( "Ext.Component", "draggable" )
		//		addRemovedProperty( "Ext.ComponentLoader", "renderer" )
		//		addRemovedProperty( "Ext.data.TreeStore", "fields" )
		//		addRemovedProperty( "Ext.util.ComponentDragger", "delegate" )
		//
		//		addRemovedMethod( "Ext.dd.StatusProxy", "hide" )
		//		addRemovedMethod( "Ext.tip.Tip", "showAt" )
		//		addRemovedMethod( "Ext.tip.Tip", "showBy" )
		//		addRemovedMethod( "Ext.tip.ToolTip", "showAt" )
		//		addRemovedMethod( "Ext.tip.QuickTip", "showAt" )
		//		addRemovedMethod( "Ext.Base", "statics" )
		//		addRemovedMethod( "Ext.dom.Element", "select" )
		//		addRemovedMethod( "Ext.Component", "getBubbleTarget" )
		//		addRemovedMethod( "Ext.tip.ToolTip", "hide" )
		//		addRemovedMethod( "Ext.tip.QuickTip", "hide" )
		//		addRemovedMethod( "Ext.tip.ToolTip", "show" )
		//		addRemovedMethod( "Ext.tip.QuickTip", "show" )
		//		addRemovedMethod( "Ext.XTemplate", "compile" )
		//		addRemovedMethod( "Ext.data.proxy.Rest", "buildUrl" )
		//		addRemovedMethod( "Ext.dd.DDTarget", "getDragEl" )
		//		addRemovedMethod( "Ext.form.field.Base", "getInputId" )
		//		addRemovedMethod( "Ext.form.Field", "getInputId" )
		//		addRemovedMethod( "Ext.form.BaseField", "getInputId" )
		//		addRemovedMethod( "Ext.form.field.Base", "getSubTplMarkup" )
		//		addRemovedMethod( "Ext.form.Field", "getSubTplMarkup" )
		//		addRemovedMethod( "Ext.form.BaseField", "getSubTplMarkup" )
		//		addRemovedMethod( "Ext.form.field.Trigger", "getSubTplMarkup" )
		//		addRemovedMethod( "Ext.form.TriggerField", "getSubTplMarkup" )
		//		addRemovedMethod( "Ext.form.TwinTriggerField", "getSubTplMarkup" )
		//		addRemovedMethod( "Ext.form.Trigger", "getSubTplMarkup" )
		//		addRemovedMethod( "Ext.form.field.Spinner", "getSubTplMarkup" )
		//		addRemovedMethod( "Ext.form.Spinner", "getSubTplMarkup" )
		//
		//		addConvertMethodToProperty( "Ext.AbstractComponent", "animate" )
		//		addConvertMethodToProperty( "Ext.util.Animate", "animate" )
		//		addConvertMethodToProperty( "Ext.form.field.Date", "safeParse" )
		//
		//		addGlobalReturnTypeOverride( "Ext.form.field.Field", "any" )
		//		addGlobalReturnTypeOverride( "Ext.slider.Multi", "any" )
		//		addGlobalReturnTypeOverride( "Ext.slider.Single", "any" )
		//
		//		addReturnTypeOverride( "Ext.data.proxy.Rest", "buildUrl", "string" )
		//		addReturnTypeOverride( "Ext.data.AbstractStore", "load", "void" )
		//		addReturnTypeOverride( "Ext.dom.AbstractElement", "hide", "Ext.dom.Element" )
		//		addReturnTypeOverride( "Ext.dom.AbstractElement", "setVisible", "Ext.dom.Element" )
		//		addReturnTypeOverride( "Ext.dom.AbstractElement", "show", "Ext.dom.Element" )
		//		addReturnTypeOverride( "Ext.form.field.Text", "setValue", "any" )
		//		addReturnTypeOverride( "Ext.form.field.Base", "getRawValue", "any" )
		//		addReturnTypeOverride( "Ext.form.field.Field", "getName", "string" )
		//		addReturnTypeOverride( "Ext.form.field.Checkbox", "getSubmitValue", "any" )
		//		addReturnTypeOverride( "Ext.form.field.Base", "getSubmitValue", "any" )
		//		addReturnTypeOverride( "Ext", "setVersion", "any" )
		//		addReturnTypeOverride( "Ext.Version", "setVersion", "any" )
		//
		// Added By JeT
		addRemovedProperty( "Ext.chart.PolarChart", "center" )
		addRemovedProperty( "Ext.enums.Layout", "ux.center" )

		addReturnTypeOverride( "Ext.chart.AbstractChart", "setStyle", "Ext.Component" )
		addReturnTypeOverride( "Ext.data.proxy.Rest", "buildUrl", "string" )
		addReturnTypeOverride( "Ext.data.RestProxy", "buildUrl", "string" )
		addReturnTypeOverride( "Ext.data.Store", "load", "Ext.data.Store" )
		addReturnTypeOverride( "Ext.data.TreeStore", "load", "Ext.data.Store" )
		addReturnTypeOverride( "Ext.dd.StatusProxy", "hide", "Ext.Component" )
		addRemovedMethod( "Ext.dom.CompositeElementLite", "id" )
		addReturnTypeOverride( "Ext.form.field.Base", "getInputId", "string" )
		addReturnTypeOverride( "Ext.form.field.Base", "getSubTplMarkup", "string" )
		addReturnTypeOverride( "Ext.form.Field", "getInputId", "string" )
		addReturnTypeOverride( "Ext.form.BaseField", "getInputId", "string" )
		addReturnTypeOverride( "Ext.form.BaseField", "getSubTplMarkup", "string" )
		addReturnTypeOverride( "Ext.form.field.Checkbox", "getRawValue", "string" )
		addReturnTypeOverride( "Ext.form.field.ComboBox", "getSubTplMarkup", "string" )
		addReturnTypeOverride( "Ext.form.ComboBox", "getSubTplMarkup", "string" )
		addReturnTypeOverride( "Ext.form.field.File", "setValue", "Ext.form.field.Text" )
		addReturnTypeOverride( "Ext.form.Field", "getSubTplMarkup", "string" )
		addReturnTypeOverride( "Ext.ux.form.FileUploadField", "setValue", "Ext.form.field.Text" )
		addReturnTypeOverride( "Ext.form.field.Tag", "isEqual", "boolean" )
		addReturnTypeOverride( "Ext", "setVersion", "void" )
		addReturnTypeOverride( "Ext.grid.selection.SpreadsheetModel", "getCount", "number" )
		addReturnTypeOverride( "Ext.grid.selection.SpreadsheetModel", "getSelectionMode", "string" )
		addReturnTypeOverride( "Ext.grid.selection.SpreadsheetModel", "isLocked", "boolean" )
		addReturnTypeOverride( "Ext.grid.selection.SpreadsheetModel", "isRangeSelected", "boolean" )
		addReturnTypeOverride( "Ext.slider.SingleSlider", "setValue", "Ext.form.field.Field" )
		addReturnTypeOverride( "Ext.slider.Slider", "setValue", "Ext.form.field.Field" )
		addReturnTypeOverride( "Ext.Slider", "setValue", "Ext.form.field.Field" )
		addReturnTypeOverride( "Ext.slider.Single", "setValue", "Ext.form.field.Field" )
		addReturnTypeOverride( "Ext.slider.SingleSlider", "setValue", "Ext.form.field.Field" )
		addReturnTypeOverride( "Ext.form.SliderField", "setValue", "Ext.form.field.Field" )
		addReturnTypeOverride( "Ext.tip.ToolTip", "hide", "Ext.Component" )
		addReturnTypeOverride( "Ext.tip.ToolTip", "show", "Ext.Component" )
		addReturnTypeOverride( "Ext.tip.ToolTip", "showAt", "Ext.Component" )
		addReturnTypeOverride( "Ext.tip.Tip", "showAt", "Ext.Component" )
		addReturnTypeOverride( "Ext.ToolTip", "hide", "Ext.Component" )
		addReturnTypeOverride( "Ext.ToolTip", "show", "Ext.Component" )
		addReturnTypeOverride( "Ext.ToolTip", "showAt", "Ext.Component" )
		addReturnTypeOverride( "Ext.tip.QuickTip", "hide", "Ext.Component" )
		addReturnTypeOverride( "Ext.tip.QuickTip", "show", "Ext.Component" )
		addReturnTypeOverride( "Ext.tip.QuickTip", "showAt", "Ext.Component" )
		addReturnTypeOverride( "Ext.QuickTip", "hide", "Ext.Component" )
		addReturnTypeOverride( "Ext.QuickTip", "show", "Ext.Component" )
		addReturnTypeOverride( "Ext.QuickTip", "showAt", "Ext.Component" )
		addReturnTypeOverride( "Ext.Tip", "showAt", "Ext.Component" )
		addRemovedProperty( "Ext.tree.Panel", "animate" )
		addRemovedProperty( "Ext.TreePanel", "animate" )
		addRemovedProperty( "Ext.tree.TreePanel", "animate" )
		addRemovedProperty( "Ext.tree.View", "animate" )
		addRemovedProperty( "Ext.window.Toast", "animate" )
		addReturnTypeOverride( "Ext.draw.engine.excanvas", "getContext", "CanvasRenderingContext2D" )
		addMissingClass( "Ext.ux.colorpick.ISelection" )
		addMissingClass( "Ext.ux.colorpick.ISelector" )
		addMissingClass( "Ext.ux.colorpick.IButton" )
		addMissingClass( "Ext.ux.colorpick.IField" )
	}

	def addMissingClass( className ) {
		if( !specialCases[ "addClass" ][ className ] ) specialCases[ "addClass" ][ className ] = [:]
				specialCases[ "addClass" ][ className ] = true
	}
	
	def addRemovedProperty( className, propertyName ) {
		if( !specialCases[ "removeProperty" ][ className ] ) specialCases[ "removeProperty" ][ className ] = [:]
		specialCases[ "removeProperty" ][ className ][ propertyName ] = true
	}

	def addRemovedMethod( className, methodName ) {
		if( !specialCases[ "removeMethod" ][ className ] ) specialCases[ "removeMethod" ][ className ] = [:]
		specialCases[ "removeMethod" ][ className ][ methodName ] = true
	}

	def addConvertMethodToProperty( className, methodName ) {
		if( !specialCases[ "methodToProperty" ][ className ] ) specialCases[ "methodToProperty" ][ className ] = [:]
		specialCases[ "methodToProperty" ][ className ][ methodName ] = true
	}

	def addGlobalReturnTypeOverride( className, newReturnType="any" ) {
		specialCases[ "globalReturnTypeOverride" ][ className ] = newReturnType
	}

	def addReturnTypeOverride( className, methodName, newReturnType="any" ) {
		if( !specialCases[ "returnTypeOverride" ][ className ] ) specialCases[ "returnTypeOverride" ][ className ] = [:]
		specialCases[ "returnTypeOverride" ][ className ][ methodName ] = newReturnType
	}

	def addMethodParameterOverride( className, methodName, parameterName, newType="any" ) {
		if( !specialCases[ "methodParameterOverride" ][ className ] ) specialCases[ "methodParameterOverride" ][ className ] = [:]
		if( !specialCases[ "methodParameterOverride" ][ className ][ methodName ] ) specialCases[ "methodParameterOverride" ][ className ][ methodName ] = [:]
		specialCases[ "methodParameterOverride" ][ className ][ methodName ][ parameterName ] = newType
	}

	def addForcedInclude( className, methodName ) {
		if( !specialCases[ "forcedInclude" ][ className ] ) specialCases[ "forcedInclude" ][ className ] = [:]
		specialCases[ "forcedInclude" ][ className ][ methodName ] = true
	}

	def addRewriteMethod( className, methodName, replacementJson ) {
		if( !specialCases[ "rewriteMethod" ][ className ] ) specialCases[ "rewriteMethod" ][ className ] = [:]
		specialCases[ "rewriteMethod" ][ className ][ methodName ] = replacementJson
	}

	def addPropertyTypeOverride( className, propertyName, newType="any" ) {
		if( !specialCases[ "propertyTypeOverride" ][ className ] ) specialCases[ "propertyTypeOverride" ][ className ] = [:]
		specialCases[ "propertyTypeOverride" ][ className ][ propertyName ] = newType
	}

	def shouldRemoveProperty( className, propertyName ) {
		return ( specialCases[ "removeProperty" ][ className ] && specialCases[ "removeProperty" ][ className ][ propertyName ] )
	}

	def shouldRemoveMethod( className, methodName ) {
		return ( specialCases[ "removeMethod" ][ className ] && specialCases[ "removeMethod" ][ className ][ methodName ] )
	}

	def shouldConvertToProperty( className, methodName ) {
		return ( specialCases[ "methodToProperty" ][ className ] && specialCases[ "methodToProperty" ][ className ][ methodName ] )
	}

	def shouldForceInclude( className, methodName ) {
		return ( specialCases[ "forcedInclude" ][ className ] && specialCases[ "forcedInclude" ][ className ][ methodName ] )
	}

	def shouldRewriteMethod( className, methodName ) {
		return ( specialCases[ "rewriteMethod" ][ className ] && specialCases[ "rewriteMethod" ][ className ][ methodName ] )
	}

	def getReturnTypeOverride( className, methodName=null ) {
		//		if ( methodName == 'getContext' ) {
		//		println 'class=' + className + ' method: ' + methodName
		//		println specialCases[ "returnTypeOverride" ]
		//		println specialCases[ "returnTypeOverride" ][ className ]
		//		println specialCases[ "returnTypeOverride" ][ className ][ methodName ]
		//		}
		if( methodName && specialCases[ "returnTypeOverride" ][ className ] && specialCases[ "returnTypeOverride" ][ className ][ methodName ] ) {
			println ' -> Change return type of ' + className + '.' + methodName + '() to ' + specialCases[ "returnTypeOverride" ][ className ][ methodName ]
			return specialCases[ "returnTypeOverride" ][ className ][ methodName ]
		}
		return specialCases[ "globalReturnTypeOverride" ][ className ]
	}

	def getMethodParameterOverride( className, methodName, parameterName ) {
		if( specialCases[ "methodParameterOverride" ][ className ] && specialCases[ "methodParameterOverride" ][ className ][ methodName ] && specialCases[ "methodParameterOverride" ][ className ][ methodName ][ parameterName ] ) {
			return specialCases[ "methodParameterOverride" ][ className ][ methodName ][ parameterName ]
		}

		return null
	}

	def getRewriteMethod( className, methodName, methodJson ) {
		if( methodName && specialCases[ "rewriteMethod" ][ className ] && specialCases[ "rewriteMethod" ][ className ][ methodName ] )
			return methodJson << specialCases[ "rewriteMethod" ][ className ][ methodName ]

		return null
	}

	def getPropertyTypeOverride( className, propertyName=null ) {
		if( propertyName && specialCases[ "propertyTypeOverride" ][ className ] && specialCases[ "propertyTypeOverride" ][ className ][ propertyName ] )
			return specialCases[ "propertyTypeOverride" ][ className ][ propertyName ]
		return null
	}

}
