import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class PlayerList extends React.Component
{
	componentDidMount() 
	{
        fetch('/players')
            .then(response => response.json())
            .then(data => this.setState({players: data}));
    }
}
export default PlayerList;