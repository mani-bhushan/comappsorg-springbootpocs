package com.apps.org.entity.generators;

import java.io.Serializable;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(
        name = "GSN_SEQ",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "GSN_SEQ"),
                @Parameter(name = "initial_value", value = "1000"),
                @Parameter(name = "increment_size", value = "1")
        }
)
public class PrefixedSequenceIdGenerator implements Serializable {

	private static final long serialVersionUID = 4926468583005150701L;

}
