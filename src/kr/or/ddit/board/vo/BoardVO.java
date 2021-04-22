package kr.or.ddit.board.vo;

public class BoardVO {

	private int boardNum;
	private String memId;
	private String boardTitle;
	private String boardContent;
	private String boardDate;
	private String boardWriter;
	private String boardReple;
	private int boardCount;
	private String boardPath;
	private long atchFileId = -1;
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardReple() {
		return boardReple;
	}
	public void setBoardReple(String boardReple) {
		this.boardReple = boardReple;
	}
	public int getBoardCount() {
		return boardCount;
	}
	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}
	public String getBoardPath() {
		return boardPath;
	}
	public void setBoardPath(String boardPath) {
		this.boardPath = boardPath;
	}
	public long getAtchFileId() {
		return atchFileId;
	}
	public void setAtchFileId(long atchFileId) {
		this.atchFileId = atchFileId;
	}
	
	@Override
	public String toString() {
		return "BoardVO [boardNum=" + boardNum + ", memId=" + memId + ", boardTitle=" + boardTitle + ", boardContent="
				+ boardContent + ", boardDate=" + boardDate + ", boardWriter=" + boardWriter + ", boardReple="
				+ boardReple + ", boardCount=" + boardCount + ", boardPath=" + boardPath + "]";
	}
}
