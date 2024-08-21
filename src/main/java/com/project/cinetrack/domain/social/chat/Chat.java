package com.project.cinetrack.domain.social.chat;

import java.time.LocalDateTime;
import java.util.List;

import com.project.cinetrack.domain.social.chat.dto.DataSendMessage;
import com.project.cinetrack.domain.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "chat")
public class Chat {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @ManyToOne
    @JoinColumn(name = "user1_id", nullable = false)
	private User user1;
    @ManyToOne
    @JoinColumn(name = "user2_id", nullable = false)
    private User user2;
    @OneToMany(mappedBy = "chat")
    private List<Message> messages;
    private LocalDateTime createdAt;
    
    public Chat() { }
    
	public Chat(DataSendMessage data, User byNome, User byId) {
	
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public User getUser1() {
		return user1;
	}
	
	public void setUser1(User user1) {
		this.user1 = user1;
	}
	
	public User getUser2() {
		return user2;
	}
	
	public void setUser2(User user2) {
		this.user2 = user2;
	}
	
	public List<Message> getMessages() {
		return messages;
	}
	
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
   
}
