import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-text-field/src/vaadin-email-field.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-custom-field/src/vaadin-custom-field.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';

class FormularioView extends PolymerElement {

  static get template() {
    return html`
<style include="shared-styles lumo-typography">
:host {
  display: block;
  margin: 0 auto;
  max-width: 1024px;
  padding: 0 var(--lumo-space-l);
}
</style>
<h3>Personal information</h3>
<vaadin-form-layout style="width: 100%;">
 <vaadin-text-field label="First name" id="firstName"></vaadin-text-field>
 <vaadin-text-field label="Last name" id="lastName"></vaadin-text-field>
 <vaadin-date-picker id="birthday" label="Birthday"></vaadin-date-picker>
 <vaadin-custom-field id="phoneNumber" label="Phone number" value="	">
  <vaadin-horizontal-layout theme="spacing">
   <vaadin-combo-box id="pnCountryCode" style="width: 120px;" pattern="\\+\\d*" placeholder="Country" prevent-invalid-input></vaadin-combo-box>
   <vaadin-text-field id="pnNumber" style="flex-grow: 1;" pattern="\\d*" prevent-invalid-input></vaadin-text-field>
  </vaadin-horizontal-layout>
 </vaadin-custom-field>
 <vaadin-email-field id="email" label="Email address"></vaadin-email-field>
 <vaadin-text-field id="occupation" label="Occupation"></vaadin-text-field>
</vaadin-form-layout>
<vaadin-horizontal-layout style="margin-top: var(--lumo-space-m); margin-bottom: var(--lumo-space-l);" theme="spacing">
 <vaadin-button theme="primary" id="save">
   Save 
 </vaadin-button>
 <vaadin-button id="cancel">
   Cancel 
 </vaadin-button>
</vaadin-horizontal-layout>
`;
  }

  static get is() {
    return 'formulario-view';
  }

  static get properties() {
    return {
      // Declare your properties here.
    };
  }
}

customElements.define(FormularioView.is, FormularioView);
