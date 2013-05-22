# ExtJS TypeScript Definition Generator


## Quick (Temporary) Initial Notes
* Untyped and fully typed definition files are available in the /definition folder.
* Add a reference to the definition at the top of your .ts file.
* Cast configuration blocks to the appropriate interface to enable code hinting.
* Since methods in a TS file are added to the prototype and not the instance, it's necessary to declare functions as properties (see example).


Example: MyCompanyGridPanel.ts:
```
/// <reference path="./definitions/ExtJS-4.2.0-Typed.d.ts" />

class MyCompanyGridPanel extends Ext.grid.Panel {
    extend: String = "Ext.grid.Panel";
    alias: String = "widget.myApp-view-myCompanyGridPanel";
    companyStore: Ext.data.JsonStore;

    constructor() {
        super();
    }

    // Decalare methods as properties, as shown below. 
    // Otherwise, they'll be lost when ExtJS rewrites the Object's prototype.
    initComponent = function (cfg: Object = {}) {
        Ext.apply(this, <Ext.grid.IPanel>{
            itemId: "companyGridPanel",
            title: "Company Listing VIA TYPESCRIPT!",
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
                  text: "Price"
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
              <Ext.form.field.ICheckbox>{
                  xtype: "checkbox",
                  itemId: "manufacturingFilter",
                  boxLabel: "Show only Manufacturing companies"
              }
            ]
        });
        return this.callParent(arguments);
    }
}

Ext.define("MyApp.view.MyCompanyGridPanel", new MyCompanyGridPanel());
```

This will generate some extra JS where TypeScript creates a JS class, super method, etc. But since ExtJS rewrites the prototype of the object as part of the object creation, I don't believe this has an impact on the running program. I'll need to do more testing to make sure.
