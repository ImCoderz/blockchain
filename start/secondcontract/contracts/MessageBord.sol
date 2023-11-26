// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.13;

contract MessageBoard{
    address public owner;
    struct Message {
        address sender;
        string[] content;
    }
    Message[] private  messages;
    event NewMessage(address indexed sender,string message);
    constructor(){
        owner=msg.sender;
    }
    function postMessage(string memory message) public {
        bool messageExists = false;
        uint senderMessageIndex;

        // Search for existing messages from the sender
        for (uint i = 0; i < messages.length; i++) {
            if (messages[i].sender == msg.sender) {
                messageExists = true;
                senderMessageIndex = i;
                break;
            }
        }
        if (messageExists) {
            // Add the new message to the sender's existing messages
            messages[senderMessageIndex].content.push(message);
        } else {
            Message memory newMessage = Message(msg.sender, new string[](1));
            newMessage.content[0] = message;
            messages.push(newMessage);
        }
        emit NewMessage(msg.sender, message);
    }
    
    function getMessagesCount()public view returns (uint256){
        return messages.length;
    }

    function getMessages()public view returns(Message[] memory){
        return messages;
    }

    function getMessageWithIndex(uint256 index)public view returns(string[] memory){
        require(index<messages.length,"Index out of bonds");
        return messages[index].content;
    }

    function getAddressesWithIndex(uint256 index)public view returns(address){
        require(index<messages.length,"Index out of bonds");
        return messages[index].sender;
    }

    function getBothWithIndex(uint256 index)public view returns(Message memory){
        require(index<messages.length,"Index out of bonds");
        return messages[index];
    }

    function getMessageWithAddress(address person) public view returns (string[] memory) {
        string[] memory personMessages;
        // Search for existing messages from the provided address
        for (uint i = 0; i < messages.length; i++) {
            if (messages[i].sender == person) {
                personMessages = messages[i].content;
                break;
            }
        }
        return personMessages;
    }

    
}