import {moduleMetadata} from '@storybook/angular';
import { Story, Meta } from '@storybook/angular/types-6-0';
import {HomeComponent} from './home.component';
import {MatButtonModule} from '@angular/material/button';

export default {
  title: 'UI-Template/HomeComponent',
  component: HomeComponent,
  decorators: [moduleMetadata({imports: [MatButtonModule]})]
} as Meta;

const Template: Story<HomeComponent> = () => ({

})

export const General = Template.bind({});
