# ExtJS TypeScript Definition Generator

#### Note: These definitions are now available in the [DefinitelyTyped](https://github.com/borisyankov/DefinitelyTyped) repository.

## Quick (Temporary) Initial Notes
* Untyped and fully typed definition files are available in the /definition folder, BUT...
* *You almost certainly just want the "-Interfaces" definition, since creating real classes and using them isn't an option (see below)*
* Add a reference to the definition at the top of your .ts file.
* Cast configuration blocks to the appropriate interface to enable code hinting.
* If you want to try running this with your own JSDuck output, check build.gradle file's ConfigGroups, and place the JSON files in the appropriate location.

## Update
* After a LOT of trial and error, it looks like casting objects to Ext JS interfaces is the only option. Trying to create concrete TypeScript classes that extend concrete Ext JS classes causes myriad conflicts between the modules, classes, extends, and super code generated by the TS compiler and the Ext JS class system. :-/
* Not ideal, but it still maintains code hinting/insight and type checking, which are the two most important things.
* The example below has been updated to show this approach.

Example: CompanyGridPanel.ts:
```
/// <reference path="./definitions/ExtJS-4.2.0-Typed.d.ts" />

Ext.define("CompanyGridPanel", <Ext.grid.IPanel>{
    extend: "Ext.grid.Panel",
    alias: "widget.companyGridPanel",

    config: {
        companyStore: null
    },

    initComponent: function () {
        Ext.applyIf(this, {
            itemId: "companyGridPanel",
            title: "Company Listing",
            store: this.companyStore,
            columnLines: true,
            
            columns: [
              <Ext.grid.column.IColumn>{
                  xtype: "gridcolumn",
                  dataIndex: "company",
                  text: "Company",
                  flex: 1
              }, <Ext.grid.column.INumber>{
                  xtype: "numbercolumn",
                  dataIndex: "price",
                  text: "Price",
                  renderer: Ext.util.Format.usMoney
              }, <Ext.grid.column.INumber>{
                  xtype: "numbercolumn",
                  dataIndex: "change",
                  text: "Change",
                  format: "0.00"
              }, <Ext.grid.column.INumber>{
                  xtype: "numbercolumn",
                  dataIndex: "pctChange",
                  text: "% Change",
                  format: "0.00"
              }, <Ext.grid.column.IDate>{
                  xtype: "datecolumn",
                  dataIndex: "lastChange",
                  text: "Last Change"
              }, <Ext.grid.column.IColumn>{
                  xtype: "gridcolumn",
                  dataIndex: "industry",
                  text: "Industry"
              }
            ],

            tbar: [
              {
                  xtype: "checkbox",
                  itemId: "manufacturingFilter",
                  boxLabel: "Show only Manufacturing companies"
              }
            ]
        });

        return this.callParent(arguments);
    }
});
```