import './App.css';
import { Container, Table, Navbar } from 'reactstrap';

const React = require('react'); 

class App extends React.Component 
{ 
	state = {
		players: [],
		name: [],
		totalYards: [],
		longestRush: [],
		totalRushingTouchdowns: []
	};

	constructor(props) 
	{
		super(props);
		this.state = {players: [],
		              name: [],
                      filterURL: [], 
                      savedURL: [], 
                      totalYards: [],
					  longestRush: [],
			          totalRushingTouchdowns: []};
		this.handlePlayerChange = this.handlePlayerChange.bind(this);
		this.handleChange = this.handleChange.bind(this);
		this.handleTotalRushingSort = this.handleTotalRushingSort.bind(this);
		this.handleLongestRushSort = this.handleLongestRushSort.bind(this);
		this.handleTotalRushingTouchdownsSort = this.handleTotalRushingTouchdownsSort.bind(this);
		this.refreshPlayers = this.refreshPlayers.bind(this);
	}
	
	async refreshPlayers(event)
	{
		var url = 'name=' + this.state.name + '&totalRushingYards=' + this.state.totalYards + '&longestRush=' + this.state.longestRush + '&totalRushingTouchdowns=' + this.state.totalRushingTouchdowns;
		this.setState({savedURL: url});
		url = 'players?' + url;
		console.log(url);
		
		fetch(url)
			.then((result) => result.json())
			.then((jsonResult) => {
				this.setState({players: jsonResult});
			});
	    event.preventDefault();
	}
	
	handlePlayerChange(event) 
	{
		var playerURL = this.state.savedURL;
		var newURL = playerURL.replace('name=' + this.state.name, 'name=' + this.state.filterURL);
		this.setState({savedURL: newURL});
		this.setState({name: this.state.filterURL}, function(){this.refreshPlayers(event);});
	    event.preventDefault();
	}
	
	refreshSortParams(event) 
	{	
		this.setState({totalYards: ''});
		this.setState({longestRush: ''});
		this.setState({totalRushingTouchdowns: ''});
		event.preventDefault();
	}
	
	handleTotalRushingSort(event) 
	{
		var nextDirection = this.state.totalYards === 'asc' ? 'desc' : this.state.totalYards === 'desc' ? '' : 'asc';
		console.log(nextDirection);
		this.refreshSortParams(event);
		this.setState(() => {
		  return {totalYards: nextDirection};
			}, function() {
				this.refreshPlayers(event);
			});
		//this.refreshPlayers(event);
	    event.preventDefault();
	}
	
	handleLongestRushSort(event) 
	{
		var nextDirection = this.state.longestRush === 'asc' ? 'desc' : this.state.longestRush === 'desc' ? '' : 'asc';
		this.refreshSortParams(event);
		console.log(nextDirection);
		this.setState(() => {
		  return {longestRush: nextDirection};
			}, function() {
				this.refreshPlayers(event);
			});
		//this.refreshPlayers(event);
	    event.preventDefault();
	}
	
	handleTotalRushingTouchdownsSort(event) 
	{
		var nextDirection = this.state.totalRushingTouchdowns === 'asc' ? 'desc' : this.state.totalRushingTouchdowns === 'desc' ? '' : 'asc';
		this.refreshSortParams(event);
		console.log(nextDirection);
		this.setState(() => {
		  return {totalRushingTouchdowns: nextDirection};
			}, function() {
				this.refreshPlayers(event);
			});
		//this.refreshPlayers(event);
	    event.preventDefault();
	}
	
	handleChange(event) 
	{
	    this.setState({filterURL: event.target.value}); 
	}
	
	async componentDidMount() 
	{
		var parameterURL = 'name=';
		var playerURL = '/players?' + parameterURL;
	    const response = await fetch(playerURL);
	    const body = await response.json();
	    this.setState({players: body});
		this.setState({savedURL: parameterURL});
		this.setState({totalYards: ''});
	}

	render() 
	{ 
		const {players, isLoading} = this.state;
		
		if (isLoading)
		{
			return <p>Loading...</p>;
		}
		
		const playerList = players.map(player =>
			{
				return <tr key={player.name}>
					     <td style={{whiteSpace: 'nowrap'}}>{player.name}</td>
                         <td style={{whiteSpace: 'nowrap'}}>{player.team}</td>
                         <td style={{whiteSpace: 'nowrap'}}>{player.position}</td>
                         <td style={{whiteSpace: 'nowrap'}}>{player.rushingAttemptsPerGameAverage}</td>
                         <td style={{whiteSpace: 'nowrap'}}>{player.rushingAttempts}</td>
                         <td style={{whiteSpace: 'nowrap'}}>{player.totalRushingYards}</td>
                         <td style={{whiteSpace: 'nowrap'}}>{player.rushingAverageYardsPerAttempt}</td>
                         <td style={{whiteSpace: 'nowrap'}}>{player.rushingYardsPerGame}</td>
                         <td style={{whiteSpace: 'nowrap'}}>{player.totalRushingTouchdowns}</td>
                         <td style={{whiteSpace: 'nowrap'}}>{player.longestRush}{player.isLongestRushATouchdownString}</td>
                         <td style={{whiteSpace: 'nowrap'}}>{player.rushingFirstDowns}</td>
                         <td style={{whiteSpace: 'nowrap'}}>{player.rushingFirstDownPercentage}</td>
                         <td style={{whiteSpace: 'nowrap'}}>{player.rushing20PlusYardsEach}</td>
                         <td style={{whiteSpace: 'nowrap'}}>{player.rushing40PlusYardsEach}</td>
                         <td style={{whiteSpace: 'nowrap'}}>{player.rushingFumbles}</td>
					   </tr>
			} );
		
		return (
        <div className="App">
          <Navbar/>
          <Container fuild>
            <div>
              <form onSubmit={this.handlePlayerChange}>
                <label>
	              Player Name: <input type="text" value={this.state.filterURL} onChange={this.handleChange} />        
                </label>
	            <input type="submit" value="Submit" />
	           </form>
			  <a href={'http://localhost:8080/players.csv?' + this.state.savedURL}>Download CSV</a>
            </div>
            <h3>Players</h3>
            <Table className="mt-4">  
              <tr>
                <th>Name</th>
                <th>Team</th>
                <th>Position</th>
                <th>Att/G</th>
                <th>Att</th>
                <th onClick={this.handleTotalRushingSort} style={{cursor:'pointer'}}>Yds {this.state.totalYards === 'asc' ? '▲' : this.state.totalYards === 'desc' ? '▼' : ''}</th>
                <th>Avg</th>
                <th>Yds/G</th>
                <th onClick={this.handleTotalRushingTouchdownsSort} style={{cursor:'pointer'}}>TD {this.state.totalRushingTouchdowns === 'asc' ? '▲' : this.state.totalRushingTouchdowns === 'desc' ? '▼' : ''}</th>
                <th onClick={this.handleLongestRushSort} style={{cursor:'pointer'}}>Lng {this.state.longestRush === 'asc' ? '▲' : this.state.longestRush === 'desc' ? '▼' : ''}</th>
                <th>1st</th>
                <th>1st%</th>
                <th>20+</th>
                <th>40+</th>
                <th>FUM</th>
              </tr>
              <tbody>{playerList}</tbody>
            </Table>
          </Container>  
        </div>
    );
	}
}
export default App;
