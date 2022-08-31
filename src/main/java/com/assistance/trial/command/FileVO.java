package com.assistance.trial.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FileVO {
	private int fileId;
    private String filePath;
    private String fileSaveName;
    private String fileOriginalName;
}
