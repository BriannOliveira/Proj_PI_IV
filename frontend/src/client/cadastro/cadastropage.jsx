// eslint-disable-next-line no-unused-vars
import React, { useState } from 'react';

export default function Cadastro() {
    const [name, setName] = useState('');
    const [gender, setGender] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [phone, setPhone] = useState('');

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        switch (name) {
            case 'name':
                setName(value);
                break;
            case 'gender':
                setGender(value);
                break;
            case 'email':
                setEmail(value);
                break;
            case 'password':
                setPassword(value);
                break;
            case 'phone':
                setPhone(value);
                break;
            default:
        }
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        console.log('Registration submitted:', { name, gender, email, password, phone });
    };

    return (
        <div className="container">
            <div className="left-side">
                {/* Conteúdo do lado esquerdo (imagem de fundo, etc.) */}
            </div>
            <div className="right-side">
                <img src="logoWood.png" alt="Logotipo" className="logo" />
                <p className="greeting-1">Olá Usuário...</p>
                <p className="greeting-2">Se conecte conosco!</p>
                <div className="registration-form">
                    <form onSubmit={handleSubmit}>
                        <div className="form-group">
                            <input
                                type="text"
                                name="name"
                                placeholder="Nome"
                                value={name}
                                onChange={handleInputChange}
                                required
                            />
                        </div>
                        <div className="form-group">
                            <select
                                name="gender"
                                value={gender}
                                onChange={handleInputChange}
                                required
                            >
                                <option value="">Gênero</option>
                                <option value="male">Masculino</option>
                                <option value="female">Feminino</option>
                                <option value="other">Outro</option>
                            </select>
                        </div>
                        <div className="form-group">
                            <input
                                type="email"
                                name="email"
                                placeholder="Email"
                                value={email}
                                onChange={handleInputChange}
                                required
                            />
                        </div>
                        <div className="form-group">
                            <input
                                type="password"
                                name="password"
                                placeholder="Senha"
                                value={password}
                                onChange={handleInputChange}
                                required
                            />
                        </div>
                        <div className="form-group">
                            <input
                                type="tel"
                                name="phone"
                                placeholder="Telefone"
                                value={phone}
                                onChange={handleInputChange}
                                required
                            />
                        </div>
                        <div className="button-group">
                            <button type="submit">CADASTRAR</button>
                        </div>
                    </form>
                </div>
                </div>
                </div>
    );
}
