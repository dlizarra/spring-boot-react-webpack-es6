import React, { Component } from 'react';
import { Navbar, Nav, NavItem, Input, Button, Glyphicon } from 'react-bootstrap';
import { LinkContainer } from 'react-router-bootstrap';
import { IndexLink } from 'react-router';

const Header = () => {
  const searchButton = (
    <Button type="submit" bsSize="small">
      <Glyphicon glyph="search" />
    </Button>
  );

  return (
    <Navbar fixedTop inverse>
      <Navbar.Header>
        <Navbar.Brand>
          <IndexLink to="/" activeStyle={{ color: '#33e0ff' }}>
            Startup Hub
          </IndexLink>
        </Navbar.Brand>
        <Navbar.Toggle />
      </Navbar.Header>
      <Navbar.Collapse>
        <Nav bsSyle="pills">
          <LinkContainer to="/projects">
            <NavItem eventKey={1} href="#">Projects</NavItem>
          </LinkContainer>
          <LinkContainer to="/users">
            <NavItem eventKey={2} href="#">Users</NavItem>
          </LinkContainer>
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
};

export default Header;
