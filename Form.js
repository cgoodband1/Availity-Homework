import React, { Component } from 'react'
import './CSS/form.css'



class Form extends Component {
    constructor(props) {
        super(props)

        this.state = {
            firstname: "",
            lastname: "",
            NPInumber: "",
            businessaddress: "",
            phone: "",
            email: "",


        }
        this.handleSubmit=this.handleSubmit.bind(this)
    }

    firsthandler = (event) => {
        this.setState({
            firstname: event.target.value
            })
    }

    lasthandler = (event) => {
        this.setState({
            lastname: event.target.value
            })
    }

    NPIhandler = (event) => {
        this.setState({
            NPInumber: event.target.value
            })
    }

    addresshandler = (event) => {
        this.setState({
            businessaddress: event.target.value
            })
    }

    phonehandler = (event) => {
        this.setState({
            phone: event.target.value
            })
    }

    emailhandler = (event) => {
        this.setState({
            email: event.target.value
            })
    }

    handleSubmit = (event) => {
        alert('${this.state.firstname} ${this.state.lastname} Registered Successfully')
        console.log(this.state);
        this.setState({
            firstname: "",
            lastname: "",
            NPInumber: "",
            businessaddress: "",
            phone: "",
            email: "",
            })
     event.preventDefault()
    }




    render() {
        return (
            <div>

                <form onSubmit={this.handleSubmit}>
                    <h1>User Registration</h1>
                    <label>First Name: </label> <input type="text" value={this.state.firstname} onChange={this.firthandler} placeholder="First Name.." /><br />
                    <label>Last Name: </label> <input type="text" value={this.state.lastname} onChange={this.lasthandler} placeholder="Last Name.." /><br />
                    <label>NPI number: </label> <input type="text" value={this.state.NPInumber} onChange={this.NPIhandler} placeholder="NPI number.." /><br />
                    <label>Business Address: </label> <input type="text" value={this.state.businessaddress} onChange={this.addresshandler} placeholder="Business Address.." /><br />
                    <label>Phone: </label> <input type="tel" value={this.state.phone} onChange={this.phonehandler} placeholder="Phone.." /><br />
                    <label>Email: </label> <input type="email" value={this.state.email} onChange={this.emailhandler} placeholder="Email.." /><br />
                    <input type="submit" value="Submit" />
                </form>

            </div>
            
        )
    }
}

export default Form