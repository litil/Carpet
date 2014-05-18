<?php

namespace Carpet\Bundle\PetBundle\Entity;

use Gedmo\Mapping\Annotation as Gedmo;
use Doctrine\ORM\Mapping as ORM;

/**
 * Event
 *
 * @ORM\Table()
 * @ORM\HasLifecycleCallbacks()
 * @ORM\Entity(repositoryClass="Carpet\Bundle\PetBundle\Entity\EventRepository")
 */
class Event
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="type", type="string", length=255)
     */
    private $type;

    /**
     * @var string
     *
     * @ORM\Column(name="params", type="text")
     */
    private $params;

    /**
     * @var datetime $created
     *
     * @Gedmo\Timestampable(on="create")
     * @ORM\Column(type="datetime")
     */
    private $created;
    

    /**
     * @ORM\ManyToOne(targetEntity="Pet", inversedBy="events")
     * @ORM\JoinColumn(name="event_id", referencedColumnName="id")
     */
    private $pet;
    
    /**
     * Get id
     *
     * @return integer 
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set type
     *
     * @param string $type
     * @return Event
     */
    public function setType($type)
    {
        $this->type = $type;

        return $this;
    }

    /**
     * Get type
     *
     * @return string 
     */
    public function getType()
    {
        return $this->type;
    }

    /**
     * Set params
     *
     * @param string $params
     * @return Event
     */
    public function setParams($params)
    {
        $this->params = $params;

        return $this;
    }

    /**
     * Get params
     *
     * @return string 
     */
    public function getParams()
    {
        return $this->params;
    }

    /**
     * Set created
     *
     * @param \DateTime $created
     * @return Event
     */
    public function setCreated($created)
    {
        $this->created = $created;

        return $this;
    }

    /**
     * Get created
     *
     * @return \DateTime 
     */
    public function getCreated()
    {
        return $this->created;
    }

    /**
     * Set pet
     *
     * @param \Carpet\Bundle\PetBundle\Entity\Pet $pet
     * @return Event
     */
    public function setPet(\Carpet\Bundle\PetBundle\Entity\Pet $pet = null)
    {
        $this->pet = $pet;

        return $this;
    }

    /**
     * Get pet
     *
     * @return \Carpet\Bundle\PetBundle\Entity\Pet 
     */
    public function getPet()
    {
        return $this->pet;
    }
}
