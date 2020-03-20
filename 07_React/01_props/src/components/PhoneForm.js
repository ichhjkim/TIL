import React, {Component} from 'react';


class PhoneForm extends Component {
    state = {
        name: '',
        phone: ''
    }
    handleChange = (e) => {
        this.setState({
            [e.target.name] : e.target.value
        })
    }
    handleCreate = (data) => {
        console.log(data);

    }
    handleSubmit = (e) => {
        e.preventDefault();
        /* html의 button은 기본적으로 submit을
            타입으로 하면 새로고침되게 되어있는데
            그걸 e.preventDefault로 막아줄것

        */
       this.props.onCreate(this.state);
       this.setState({
           name: '',
           phone: ''
       })
    }
    render() {

    
    return (
        <div className="App">
            <form onSubmit={this.handleSubmit}>
                <input 
                name="name"
                placeholder="name"
                onChange={this.handleChange} 
                value={this.state.value} 
                type="text"/>
                <br/>
                {this.state.name}
                <hr/>
                <input 
                name="phone"
                onChange={this.handleChange}
                placeholder="phone"
                type="phone"/>
                <br/>
                {this.state.phone}

                <button type="submit">등록</button>
            </form>
        </div>
        )
    }
}

export default PhoneForm