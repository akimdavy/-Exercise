	package com.example.demo.model;
	
	import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
	
	@Entity
	@Table(name = "post") 
	public class Post {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	
	    @Column(nullable = false)
	    private String title;
	
	    @Column(columnDefinition = "TEXT")
	    private String content;
	
	    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	    private Collection<Advertisement> advertisements;	
	
	    @ManyToOne
	    @JoinColumn(name = "user_id", nullable = true)
	    private User user;
	
	    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	    private Collection<Comment> comments;
	
	    public Post() {
	    }
	
	    public Post(String title, String content /*, User user*/) {
	        this.title = title;
	        this.content = content;
	        //this.user = user;
	    }
	
	    public Long getId() {
	        return id;
	    }
	
	    public void setId(Long id) {
	        this.id = id;
	    }
	
	    public String getTitle() {
	        return title;
	    }
	
	    public void setTitle(String title) {
	        this.title = title;
	    }
	
	    public String getContent() {
	        return content;
	    }
	
	    public void setContent(String content) {
	        this.content = content;
	    }
	
	    public User getUser() {
	        return user;
	    }
	
	    public void setUser(User user) {
	        this.user = user;
	    }
	
	    public Collection<Comment> getComments() {
	        return comments;
	    }
	
	    public void setComments(Collection<Comment> comments) {
	        this.comments = comments;
	    }
	    
	    public Collection<Advertisement> getAdvertisements() {
	        return advertisements;
	    }
	
	    public void setAdvertisements(Collection<Advertisement> advertisements) {
	        this.advertisements = advertisements;
	    }
	}
