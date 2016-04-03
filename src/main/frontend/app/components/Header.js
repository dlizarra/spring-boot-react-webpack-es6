import React, { Component } from 'react';
import { Navbar, Nav, NavItem } from 'react-bootstrap';


export default class Header extends Component {
  constructor(props) {
    super(props);
    this.state = {
      activeNavItem: 1
    };
  }

  handleSelect = (selectedKey) => {
    this.setState({ activeNavItem: selectedKey });
  };

  render() {
    return (
      <Navbar>
        <Navbar.Header>
          <Navbar.Brand>
            <a href="#">Startup Hub</a>
          </Navbar.Brand>
          <Navbar.Toggle />
        </Navbar.Header>
        <Nav bsSyle="pills" activeKey={this.state.activeNavItem} onSelect={this.handleSelect}>
          <NavItem eventKey={1} href="#">Projects</NavItem>
          <NavItem eventKey={2} href="#">Users</NavItem>
        </Nav>
      </Navbar>
    );
  }
}
