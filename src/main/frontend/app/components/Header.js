import React, { Component } from 'react';
import { Navbar, Nav, NavItem, Input, Button, Glyphicon } from 'react-bootstrap';


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
    const searchButton = (
      <Button type="submit" bsSize="small">
        <Glyphicon glyph="search" />
      </Button>
    );

    return (
      <Navbar fixedTop inverse>
        <Navbar.Header>
          <Navbar.Brand>
            <a href="#">Startup Hub</a>
          </Navbar.Brand>
          <Navbar.Toggle />
        </Navbar.Header>
        <Navbar.Collapse>
        <Nav bsSyle="pills" activeKey={this.state.activeNavItem} onSelect={this.handleSelect}>
          <NavItem eventKey={1} href="#">Projects</NavItem>
          <NavItem eventKey={2} href="#">Users</NavItem>
        </Nav>
        <form className="navbar-form navbar-right" role="search">
          <Input
            type="search"
            className="form-control"
            bsSize="small"
            placeholder="Search"
            buttonAfter={searchButton}
          />
        </form>
        </Navbar.Collapse>
      </Navbar>
    );
  }
}
