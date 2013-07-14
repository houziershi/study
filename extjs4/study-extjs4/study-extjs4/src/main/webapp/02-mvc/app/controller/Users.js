Ext.define('AM.controller.Users', {
	extend : 'Ext.app.Controller',

	models : [ 'User' ],
	stores : [ 'Users' ],

	views : [ 'user.List', 'user.Edit' ],

	onPanelRendered : function() {
		console.log('The panel was rendered');
	},

	editUser : function(grid, record) {
		var view = Ext.widget('useredit');
		view.down('form').loadRecord(record);
	},

	updateUser : function(button) {
		var win = button.up('window'), form = win.down('form'), //
		record = form.getRecord(), values = form.getValues();

		record.set(values);
		win.close();

		// synchronize the store after editing the record
		this.getUsersStore().sync();
	},

	init : function() {
		console.log('Initialized Users! This happens '
				+ 'before the Application launch function is called');

		this.control({
			'viewport > panel' : {
				render : this.onPanelRendered
			}
		});

		this.control({
			'viewport > userlist' : {
				itemdblclick : this.editUser
			},
			'useredit button[action=save]' : {
				click : this.updateUser
			}
		});
	}
});
