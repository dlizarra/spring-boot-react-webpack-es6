import React, { Component } from 'react';
import Header from '../components/Header';
import Identicon from '../components/Identicon';

export default class App extends Component {
  render() {
    return (
      <div>
        <Header />
        {this.props.children}
      </div>
    );
  }
}
