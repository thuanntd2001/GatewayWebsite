package spring.entity;



import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name="CONFIRMTOKEN")
public class ConfirmationTokenEntity {

    @SequenceGenerator(
            name = "confirmation_token_sequence",
            sequenceName = "confirmation_token_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "confirmation_token_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime expiresAt;

    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "MAKH"
    )
    private KhachHangEntity KhachHangEntity;

    public ConfirmationTokenEntity(String token,
                             LocalDateTime createdAt,
                             LocalDateTime expiresAt,
                             KhachHangEntity KhachHangEntity) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.KhachHangEntity = KhachHangEntity;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(LocalDateTime expiresAt) {
		this.expiresAt = expiresAt;
	}

	public LocalDateTime getConfirmedAt() {
		return confirmedAt;
	}

	public void setConfirmedAt(LocalDateTime confirmedAt) {
		this.confirmedAt = confirmedAt;
	}

	public KhachHangEntity getKhachHangEntity() {
		return KhachHangEntity;
	}

	public void setKhachHangEntity(KhachHangEntity khachHangEntity) {
		KhachHangEntity = khachHangEntity;
	}

	public ConfirmationTokenEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    
}
