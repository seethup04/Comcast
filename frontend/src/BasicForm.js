import React from 'react';
import axios from 'axios';
import logo from './logo.svg';
import './App.css';

class BasicForm extends React.Component{

    constructor(props){
        super(props);
        this.state={
            enteredString:"",
            responseData:"",
            displayResponse:false
        }
    }

    handleSubmit = (event) =>{
        event.preventDefault();
        let value=this.state.enteredString;
        const arr=value.split(",");
         let jsonData ={
            "setOfStrings":[]
        };

        arr.map((x)=>{
            jsonData.setOfStrings.push({"value":x});
        })
        console.log(jsonData)
       axios.post("http://localhost:8077/lcs",jsonData,{
           headers:{
            'Content-Type': 'application/json'
           }
       }).then((response)=>{
           console.log(response.data);
            this.setState({responseData:response.data})
            this.setState({displayResponse:true})
       })
       .catch((error) => {
           console.log("here in catch")
           console.log(error)
       })

       
    }

    handleChange = (event) => {
        this.setState({enteredString: event.target.value});
      }

    render() {
        let displayErr;
        if(this.state.displayResponse){
            let data=this.state.responseData
            console.log(data.lcs[0].value)
            displayErr= <div className="errorMsg" >
            <label>
            <h3>The LCS is :</h3>
            </label>
            <h3>{data.lcs[0].value}</h3>
          </div>
        }
        else{
            <div></div>
        }

        return (<div className="App">
            <header className="App-header">
            <React.Fragment>
                <h1>Longest Common Substring</h1>
            </React.Fragment>
        <div >
            <img src={logo} className="App-logo" alt="logo" />
            {displayErr}
        </div>
        
          <form onSubmit={this.handleSubmit}>
            <label>
              Enter the strings seperated 
              by comma for which common substring 
              is to be determined :
              <input type="text" value={this.state.value} onChange={this.handleChange} />
            </label><br /><br />
            <input type="submit" value="Submit" />
          </form>
          </header>
          
          </div>
        );
      }


}

export default BasicForm;