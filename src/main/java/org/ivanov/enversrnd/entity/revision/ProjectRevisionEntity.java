package org.ivanov.enversrnd.entity.revision;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@Table(name = "REV_INFO")
@Entity
@RevisionEntity
public class ProjectRevisionEntity {
    @Id
    @Column(name = "REV")
    @GeneratedValue(generator = "revisionSeqGen")
    @SequenceGenerator(name = "revisionSeqGen", sequenceName = "REVISION_ID_SEQUENCE", allocationSize = 1)
    @RevisionNumber
    private Long id;

    @Basic
    @Column(name = "REV_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @RevisionTimestamp
    private Date utilTimestamp;
}
