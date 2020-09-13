/**
 * 
 */
package com.sca.dao.repository.file;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sca.dao.domain.file.ScaFile;

/**
 * 
 * @author subhash
 *
 */
@Repository
public interface ScaFileRepository extends JpaRepository<ScaFile, Long>, JpaSpecificationExecutor<ScaFile> {

}
