package com.deitel.addressbook.test;

import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import com.deitel.addressbook.AddressBook;
import com.deitel.addressbook.R;
import com.deitel.addressbook.test.util.TestCaseUtil;
import com.robotium.solo.Solo;

@SuppressWarnings("rawtypes")
public class AddressBookCaseTest extends ActivityInstrumentationTestCase2 {

	private Solo solo;

	@SuppressWarnings("unchecked")
	public AddressBookCaseTest() {
		super(AddressBook.class);
	}

	@Override
	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testCesOne() throws Exception {
		String cesOne = "[, Exibir_Tela_Principal, Pressionar_Menu, Pressionar_Voltar, Exibir_Tela_Principal, Selecionar_addContact, Informar_dados_contatoR1, Pressionar_saveContact, Exibir_Tela_Principal, Selecionar_contato, Pressionar_Voltar, Exibir_Tela_Principal, Selecionar_contato, Exibir_contato, Pressionar_Menu, Pressionar_Voltar, Exibir_contato, Pressionar_Menu, Selecionar_editContact, Informar_dados_contatoR2, Exibir_msg_erro, Informar_dados_contatoR1, Pressionar_saveContact, ]";

		TestCaseUtil.executeTestCase(this, cesOne);
	}

	public void testCesTwo() throws Exception {
		String cesTwo = "[, Exibir_Tela_Principal, Pressionar_Menu, Selecionar_addContact, Informar_dados_contatoR2, Exibir_msg_erro, Informar_dados_contatoR1, Pressionar_saveContact, ]";

		TestCaseUtil.executeTestCase(this, cesTwo);
	}

	public void testCesThree() throws Exception {
		String cesThree = "[, Exibir_Tela_Principal, Selecionar_contato, Exibir_contato, Pressionar_Menu, Selecionar_deleteContact, Pressionar_Voltar, Exibir_contato, Pressionar_Menu, Selecionar_editContact, Pressionar_Voltar, Exibir_contato, Pressionar_Menu, Selecionar_deleteContact, Exibir_janelaConfirmacao, Selecionar_cancel, Exibir_contato, Pressionar_Menu, Selecionar_deleteContact, Exibir_janelaConfirmacao, Selecionar_delete, ]";

		TestCaseUtil.executeTestCase(this, cesThree);
	}

	public void Exibir_Tela_Principal() throws Exception {
	}

	public void Pressionar_Menu() throws Exception {
		solo.sendKey(KeyEvent.KEYCODE_MENU);
	}

	public void Pressionar_Voltar() throws Exception {
		solo.goBack();
	}

	public void Selecionar_contato() throws Exception {
		solo.clickInList(0);
	}

	public void Exibir_contato() throws Exception {
	}

	public void Selecionar_addContact() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_add_contact));
	}

	public void Selecionar_editContact() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_edit_contact));
	}

	public void Pressionar_saveContact() throws Exception {
		try {
			solo.clickOnButton(solo.getString(R.string.button_save_contact));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Informar_dados_contatoR1() throws Exception {
		for (int i = 0; i < 5; i++) {
			solo.clearEditText(i);
		}

		solo.enterText(0, "Guilherme");
		solo.enterText(1, "1234");
		solo.enterText(2, "guilherme@gmail.com");
		solo.enterText(3, "Av. Faria Lima, 100");
		solo.enterText(4, "São Paulo, SP, Brasil");
	}

	public void Informar_dados_contatoR2() throws Exception {
		for (int i = 0; i < 5; i++) {
			solo.clearEditText(i);
		}

		solo.enterText(0, "Guilherme de Cleva Farto");
		solo.enterText(1, "1234-4321");
		solo.enterText(2, "guilherme@gmail.com");
		solo.enterText(3, "Av. Rio Branco, 200");
		solo.enterText(4, "Rio de Janeiro, RJ, Brasil");
	}

	public void Selecionar_cancel() throws Exception {
		solo.clickOnButton(solo.getString(R.string.button_cancel));
	}

	public void Selecionar_deleteContact() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_delete_contact));
	}

	public void Selecionar_delete() throws Exception {
		solo.clickOnButton(solo.getString(R.string.button_delete));
	}

	public void Exibir_janelaConfirmacao() throws Exception {
	}

	public void Exibir_msg_erro() throws Exception {
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

}
